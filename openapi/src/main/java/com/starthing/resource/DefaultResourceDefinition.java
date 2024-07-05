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
import com.starthing.standard.ResourceStandard;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Default implements resource definition
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
final class DefaultResourceDefinition implements IResourceDefinition {

    /**
     * Local cache
     */
    private static final Map<Class<?>, IResourceDefinition> DEFINITIONS = new ConcurrentHashMap<>();

    /**
     * Create resource definition
     *
     * @param modelClass class for model
     * @return instance
     * @throws IllegalArgumentException if class does not load metadata
     */
    static IResourceDefinition of(Class<? extends ICallableModel<?>> modelClass) {
        IResourceDefinition resourceDefinition = DEFINITIONS.get(modelClass);

        if (resourceDefinition == null) {
            DEFINITIONS.computeIfAbsent(modelClass, ignored -> {
                // with resource
                final ResourceStandard.WithResource modelResource = modelClass.getAnnotation(ResourceStandard.WithResource.class);
                if (modelResource == null) {
                    throw new IllegalArgumentException("Cannot find annotation @withResource. model class: " + modelClass);
                }

                // model class
                final ParameterizedType callableParameterizedType = tryFindCallableModelClass(modelClass);
                if (callableParameterizedType == null) {
                    throw new IllegalArgumentException("Cannot find callable model class: " + modelClass);
                }
                final Type[] actualTypeArguments = callableParameterizedType.getActualTypeArguments();
                if (actualTypeArguments.length != 1) {
                    throw new IllegalArgumentException("Cannot find model class.");
                }

                final Class<?> callableClass = (Class<?>) actualTypeArguments[0];
                final ResourceStandard.WithResource callableResource = callableClass.getAnnotation(ResourceStandard.WithResource.class);
                if (callableResource == null) {
                    throw new IllegalArgumentException("Cannot find annotation @withResource. model class: " + modelClass);
                }

                return new DefaultResourceDefinition(modelClass, modelResource.version(), modelResource.code(), callableClass, callableResource.version(), callableResource.version());
            });

            resourceDefinition = DEFINITIONS.get(modelClass);
        }
        return resourceDefinition;
    }

    /**
     * Get resource definition
     *
     * @param modelClass class for model
     * @return return instance. if instance does not exist, then return null.
     */
    static @Nullable IResourceDefinition get(Class<? extends ICallableModel<?>> modelClass) {
        return DEFINITIONS.get(modelClass);
    }

    private static @Nullable ParameterizedType tryFindCallableModelClass(Class<? extends ICallableModel<?>> modelClass) {
        final Type[] genericInterfaces = modelClass.getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            final ParameterizedType parameterizedType = (ParameterizedType) genericInterface;

            if (ICallableModel.class.isAssignableFrom((Class<?>) parameterizedType.getRawType())) {
                return parameterizedType;
            }
        }
        return null;
    }

    /**
     * Class of resource
     */
    private final Class<?> resourceClass;

    /**
     * Version of resource
     */
    private final String resourceVersion;

    /**
     * Code of resource
     */
    private final String resourceCode;

    /**
     * Class of callable
     */
    private final Class<?> callableClass;

    /**
     * Version of callable
     */
    private final String callableVersion;

    /**
     * Code of callable
     */
    private final String callableCode;

    /**
     * Creation time with unix-timestamp
     */
    private final long creationTime;

    DefaultResourceDefinition(Class<?> resourceClass, String resourceVersion, String resourceCode, Class<?> callableClass, String callableVersion, String callableCode) {
        this.resourceClass = resourceClass;
        this.resourceVersion = resourceVersion;
        this.resourceCode = resourceCode;
        this.callableClass = callableClass;
        this.callableVersion = callableVersion;
        this.callableCode = callableCode;
        this.creationTime = System.currentTimeMillis();
    }

    @Override
    public Class<?> getResourceClass() {
        return this.resourceClass;
    }

    @Override
    public String getResourceVersion() {
        return this.resourceVersion;
    }

    @Override
    public String getResourceCode() {
        return this.resourceCode;
    }

    @Override
    public Class<?> getCallableClass() {
        return this.callableClass;
    }

    @Override
    public String getCallableVersion() {
        return this.callableVersion;
    }

    @Override
    public String getCallableCode() {
        return this.callableCode;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }


}
