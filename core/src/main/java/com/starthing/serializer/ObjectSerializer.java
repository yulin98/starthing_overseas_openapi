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

package com.starthing.serializer;

import com.google.gson.JsonObject;
import com.starthing.model.ICallableModel;
import com.starthing.transform.ITenantNamespace;
import com.starthing.transform.resource.IResourceDefinition;

import java.io.Serializable;

/**
 * Object serializer interface
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/07/03
 */
public interface ObjectSerializer<T extends Serializable> {

    /**
     * Object serialize coordinator
     */
    ObjectSerializer INSTANCE = new SerializerCoordinator();

    /**
     * Serialize object to bytes
     *
     * @param resource      resource
     * @param callableModel model
     */
    JsonObject serialize(ITenantNamespace namespace, T source);

    /**
     * Serialize object to bytes
     *
     * @param callableModel model
     */
    static byte[] serialize(ICallableModel<?> callableModel) {
        final IResourceDefinition resourceDefinition = IResourceDefinition.get(callableModel);
        if (resourceDefinition == null) {
            throw new IllegalArgumentException("Unable to match appropriate resource definition.");
        }

        return INSTANCE.serialize(resourceDefinition, callableModel);
    }

    /**
     * Object serializer registrar
     */
    interface SerializerRegistrar {

        /**
         * Register customize serializer
         */
        void register(CustomizeSerializer customize);

    }

    final class SerializerException extends RuntimeException {

    }

}
