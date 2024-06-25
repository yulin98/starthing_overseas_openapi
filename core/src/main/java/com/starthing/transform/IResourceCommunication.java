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

package com.starthing.transform;

import com.starthing.transform.resource.IResourceDefinition;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

/**
 * todo: ...
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public interface IResourceCommunication {

    /**
     * Default communication
     */
    IResourceCommunication DEFAULT = spi(IResourceCommunicationFactory.class);

    /**
     * Resource communicate
     */
    <T> CompletionStage<T> communicate(IResourceDefinition resourceDefinition, ITenantNamespace tenantNamespace, byte[] payload);

    /**
     * Spi loader
     */
    static IResourceCommunication spi(Class<IResourceCommunicationFactory> factoryClass) {
        final ServiceLoader<IResourceCommunicationFactory> serviceLoader = ServiceLoader.load(factoryClass, Thread.currentThread().getContextClassLoader());
        final Iterator<IResourceCommunicationFactory> iterator = serviceLoader.iterator();
        if (iterator.hasNext()) {
            final IResourceCommunicationFactory communicationFactory = iterator.next();

            return communicationFactory.get();
        }

        throw new IllegalArgumentException("Cannot find implementation of IResourceCommunicationFactory");
    }

    /**
     * Factory for {@link IResourceCommunication}
     */
    interface IResourceCommunicationFactory extends Supplier<IResourceCommunication> {

    }

}
