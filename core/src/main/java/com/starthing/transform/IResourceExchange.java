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

import java.util.concurrent.CompletionStage;

/**
 * Resource request exchange
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public interface IResourceExchange {

    <T> CompletionStage<T> exchange(ITenantNamespace tenantNamespace, ICallableModel<T> callableModel);

}
