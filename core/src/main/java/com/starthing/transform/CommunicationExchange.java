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

import com.starthing.model.ICallableModel;
import com.starthing.transform.resource.IResourceDefinition;

import java.util.concurrent.CompletionStage;

/**
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
final class CommunicationExchange {

    /**
     * Resource communicate
     */
    private final IResourceCommunication communication = IResourceCommunication.DEFAULT;

    @SuppressWarnings("unchecked")
    public <T> CompletionStage<T> exchange(ITenantNamespace tenantNamespace, ICallableModel<T> callableModel) {
        // create resource definition
        final IResourceDefinition resourceDefinition = IResourceDefinition.of((Class<? extends ICallableModel<?>>) callableModel.getClass());

        // resource communicate
        return communication.communicate(resourceDefinition, tenantNamespace, null)
                .thenApply(source -> {

                    return null;
                });
    }
}
