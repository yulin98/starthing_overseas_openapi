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

package com.starthing.resource;

import com.starthing.model.ICallableModel;
import org.jetbrains.annotations.Nullable;

/**
 * Resource definition interface
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
public interface IResourceDefinition {

    /**
     * Class of resource
     */
    Class<?> getResourceClass();

    /**
     * Version of resource
     */
    String getResourceVersion();

    /**
     * Code of resource
     */
    String getResourceCode();

    /**
     * Class of callable
     */
    Class<?> getCallableClass();

    /**
     * Version of callable
     */
    String getCallableVersion();

    /**
     * Code of callable
     */
    String getCallableCode();

    /**
     * Creation time with unix-timestamp
     */
    long getCreationTime();

    /**
     * Load resource definition by model
     *
     * @param callableModel callable model
     * @return return resource definition. if not exist then return null.
     */
    @SuppressWarnings("unchecked")
    static @Nullable IResourceDefinition get(ICallableModel<?> callableModel) {
        final Class<? extends ICallableModel<?>> modelClass = (Class<? extends ICallableModel<?>>) callableModel.getClass();

        return DefaultResourceDefinition.get(modelClass);
    }

    /**
     * Parse model to resource definition
     *
     * @param modelClass class of model
     * @return resource metadata
     * @throws IllegalArgumentException when parse model failure, then will throws this error.
     */
    static IResourceDefinition of(Class<? extends ICallableModel<?>> modelClass) {
        return DefaultResourceDefinition.of(modelClass);
    }

}
