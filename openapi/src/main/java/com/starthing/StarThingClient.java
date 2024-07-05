/*
 * Copyright 2024 starthing_overseas_openapi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.starthing;

import com.starthing.model.ICallableModel;
import com.starthing.resource.IResourceDefinition;
import com.starthing.serializer.ObjectSerializer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * StarThing api client
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
final class StarThingClient implements StarThingApi {
    /**
     * Hmac sha512 algorithm
     */
    private static final String HMAC_SHA512 = "HmacSHA512";

    StarThingClient(StarThingGatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    /**
     * Service of StarThing for gateway request
     */
    private final StarThingGatewayService gatewayService;

    @Override
    @SuppressWarnings("unchecked")
    public <T> CompletionStage<T> request(ITenantNamespace namespace, ICallableModel<T> callableModel) {
        if (namespace == null || callableModel == null) {
            throw new NullPointerException("namespace and callableModel can't be null");
        }

        // create resource definition
        final IResourceDefinition resource = IResourceDefinition.of((Class<? extends ICallableModel<?>>) callableModel.getClass());
        // serialize request model
        final CompletionStage<byte[]> modelSerialization = serialize(callableModel);

        return modelSerialization.thenCompose(form -> {
            final String signature = generateSignature(namespace.getTenantSecretCode().getBytes(StandardCharsets.UTF_8), form);

            final CompletionStage<byte[]> requestCompletion = gatewayService.request(namespace.getTenantNumber(), namespace.getTenantNamespace(), resource.getResourceVersion(), resource.getResourceCode(), signature, form);

            // handler
            return requestCompletion.thenCompose(response -> {
                // successful handle
                final T deserialized = ObjectSerializer.SERIALIZER.deserialize(response, (Class<T>) resource.getCallableClass());
                return CompletableFuture.completedFuture(deserialized);
            });
        });
    }

    /**
     * Serialize instance to array of bytes
     */
    private static CompletionStage<byte[]> serialize(Object instance) {
        try {
            final byte[] serialized = ObjectSerializer.SERIALIZER.serialize(instance);

            return CompletableFuture.completedFuture(serialized);
        } catch (ObjectSerializer.SerializerException ex) {
            final CompletableFuture<byte[]> future = new CompletableFuture<>();
            future.completeExceptionally(ex);

            return future;
        }
    }

    private static String generateSignature(byte[] secretCode, byte[] content) {
        Mac sha512Hmac;

        try {
            sha512Hmac = Mac.getInstance(HMAC_SHA512);
            SecretKeySpec keySpec = new SecretKeySpec(secretCode, HMAC_SHA512);
            sha512Hmac.init(keySpec);

            byte[] macData = sha512Hmac.doFinal(content);
            return byteArrayToHex(macData);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
