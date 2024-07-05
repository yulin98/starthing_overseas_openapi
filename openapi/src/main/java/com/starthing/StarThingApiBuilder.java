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

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.util.concurrent.ExecutorService;

/**
 * todo: what are capabilities in this class. and plz introduction of this class
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/07/05
 */
public class StarThingApiBuilder implements StarThingApi.Builder {

    /**
     * BaseUri for connect to StarThing Co.,Ltd
     */
    private String gatewayUri = PRODUCT_URI;

    /**
     * Executor service for rest client
     */
    private @Nullable ExecutorService executorService;

    /**
     * Customize gateway service
     */
    private @Nullable StarThingGatewayService starThingGatewayService;

    @Override
    public StarThingApi.Builder gatewayUri(String gatewayUri) {
        if (gatewayUri == null || gatewayUri.isEmpty()) {
            throw new IllegalArgumentException("baseUrl cannot be null or empty");
        }

        this.gatewayUri = gatewayUri;
        return self();
    }

    @Override
    public StarThingApi.Builder executorService(ExecutorService executorService) {
        if (executorService == null) {
            throw new IllegalArgumentException("executorService cannot be null or empty");
        }
        if (executorService.isShutdown()) {
            throw new IllegalArgumentException("executorService is already shutdown");
        }

        this.executorService = executorService;
        return self();
    }

    @Override
    public StarThingApi.Builder starThingGatewayService(StarThingGatewayService starThingGatewayService) {
        if (starThingGatewayService == null) {
            throw new IllegalArgumentException("starThingGatewayService cannot be null or empty");
        }

        this.starThingGatewayService = starThingGatewayService;
        return self();
    }

    @Override
    public StarThingApi build() {
        StarThingGatewayService starThingGatewayService = this.starThingGatewayService;
        if (starThingGatewayService == null) {
            starThingGatewayService = buildService(this);
        }

        return null;
    }

    private static StarThingGatewayService buildService(StarThingApiBuilder apiBuilder) {
        final String gatewayUri = apiBuilder.gatewayUri;
        final ExecutorService executorService = apiBuilder.executorService;

        final RestClientBuilder clientBuilder = RestClientBuilder.newBuilder();
        clientBuilder.baseUri(URI.create(gatewayUri));

        if (executorService != null) {
            clientBuilder.executorService(executorService);
        }

        return clientBuilder.build(StarThingGatewayService.class);
    }
}
