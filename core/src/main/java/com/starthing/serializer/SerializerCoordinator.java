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

import com.starthing.model.ICallableModel;
import com.starthing.transform.resource.IResourceDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * todo: what are capabilities in this class. and plz introduction of this class
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/07/03
 */
final class SerializerCoordinator implements ObjectSerializer.SerializerRegistrar, ObjectSerializer {

    /**
     * Serializer containers
     */
    private static final Map<IResourceDefinition, ObjectSerializer> SERIALIZERS = new ConcurrentHashMap<>();
    @Override
    public void register(ObjectSerializer.CustomizeSerializer customize) {
        if (customize == null || customize.getResource() == null) {
            throw new NullPointerException("Customize resource is null");
        }

        final IResourceDefinition resource = customize.getResource();
        if (CUSTOMIZES.containsKey(resource)) {
            throw new IllegalArgumentException("Customize resource already exists");
        }

        CUSTOMIZES.computeIfAbsent(resource, ignored -> customize);
    }

    @Override
    public byte[] serialize(IResourceDefinition resource, ICallableModel<?> callableModel) {
        final IResourceDefinition resourceDefinition = IResourceDefinition.get(callableModel);
        if (resourceDefinition == null) {
            throw new IllegalArgumentException("Unable to match appropriate resource definition.");
        }

        // serialized
        final byte[] serialized;

        // try lookup customize serialize
        final CustomizeSerializer customizeSerializer = CUSTOMIZES.get(resource);
        if (customizeSerializer != null) {
            serialized = customizeSerializer.serialize(callableModel);
        } else {
            final ObjectSerializer objectSerializer = SERIALIZERS.get(resource);
            if (objectSerializer == null) {
                throw new IllegalArgumentException("Unable to match appropriate serializer, plz try to use {@link com.starthing.serializer.ObjectSerializer.CustomizeSerializer}.");
            }

            serialized = objectSerializer.serialize(resource, callableModel);
        }

        if (serialized == null || serialized.length == 0) {
            throw new IllegalArgumentException("Failed to serialize callable model.");
        }
        return serialized;
    }
}
