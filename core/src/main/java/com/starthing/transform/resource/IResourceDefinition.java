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

package com.starthing.transform.resource;

import com.starthing.model.ICallableModel;

/**
 *
 *
 * @author wunhwantseng@gmail.com
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

    static IResourceDefinition of(Class<? extends ICallableModel<?>> modelClass) {
        return DefaultResourceDefinition.of(modelClass);
    }

}
