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

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.CompletionStage;

import static com.starthing.standard.ResourceStandard.*;

/**
 * Service for request gateway api.
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/07/05
 */
@Path("/open")
public interface StarThingGatewayService {

    /**
     * Request resource
     *
     * @param tenantNumber         Tenant number
     * @param tenantNamespace      Tenant namespace
     * @param resourceVersion      Tenant version
     * @param resourceCode         Resource code
     * @param requestAuthorization Request authorization
     * @param request              Request body
     * @return Response body
     * @throws StarThingRequestException
     */
    @POST
    @Path("/apis/gateway.do")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CompletionStage<byte[]> request(
            @HeaderParam(TENANT_ID) String tenantNumber, @HeaderParam(TENANT_NAMESPACE) String tenantNamespace,
            @HeaderParam(TENANT_RESOURCE_VERSION) String resourceVersion, @HeaderParam(TENANT_RESOURCE_CODE) String resourceCode,
            @HeaderParam(TENANT_AUTHORIZATION) String requestAuthorization, byte[] request
    );

    /**
     * Bad request exception from when response status code is 4xx or 5xx, and the error code and error message can from response headers or response body. sample like:
     *
     * <p> response-header: {@code ERROR_CODE}
     * <p> response-header: {@code ERROR_MESSAGE}
     */
    final class StarThingRequestException extends RuntimeException {

        /**
         * Error code
         */
        private final ErrorCode errorCode;

        public StarThingRequestException(ErrorCode errorCode) {
            this.errorCode = errorCode;
        }

        public ErrorCode getErrorCode() {
            return errorCode;
        }

    }

}
