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

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

/**
 * todo: what are capabilities in this class. and plz introduction of this class
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/07/03
 */
public interface StarThingApi {

    /**
     * Global resource request
     *
     * @param namespace     tenant namespace
     * @param callableModel
     * @param <T>
     * @return
     * @throws com.starthing.serializer.ObjectSerializer.SerializerException
     * @throws java.io.IOException
     * @throws com.starthing.StarThingGatewayService.StarThingRequestException
     */
    <T> CompletionStage<T> request(ITenantNamespace namespace, ICallableModel<T> callableModel);

    /**
     * Builder interface for {@link StarThingApi}
     */
    interface Builder {

        /**
         * BaseUrl of development environment
         */
        String DEVELOPMENT_URI = "http://o-payment.cadmem.com/open/apis/gateway.do";

        /**
         * BaseUrl of product environment
         */
        String PRODUCT_URI = "https://gpayment.starthing.com/open/apis/gateway.do";

        /**
         * Configuration base uri
         */
        Builder gatewayUri(String gatewayUri);

        /**
         * Switch to development environment
         */
        default Builder developmentEnvironment() {
            return gatewayUri(DEVELOPMENT_URI);
        }

        /**
         * Switch to product environment
         */
        default Builder productEnvironment() {
            return gatewayUri(PRODUCT_URI);
        }

        /**
         * Executor service for rest client
         */
        Builder executorService(ExecutorService executorService);

        /**
         * Customize gateway service
         */
        Builder starThingGatewayService(StarThingGatewayService starThingGatewayService);

        /**
         * Return itself
         */
        default Builder self() {
            return this;
        }

        /**
         * Build OpenApi
         */
        StarThingApi build();

    }

}
