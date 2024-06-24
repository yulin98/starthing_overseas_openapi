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

package com.starthing.standard;

/**
 * Standard for tenant resource
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public interface ResourceStandard {

    /**
     * Tenant number.
     *
     * @see #TENANT_RESOURCE_MERCHANT
     */
    String TENANT_ID = "TENANT_ID";

    /**
     * Tenant number.
     *
     * @see #TENANT_ID
     */
    String TENANT_RESOURCE_MERCHANT = "RESOURCE_MERCHANT";

    /**
     * Tenant namespace.
     *
     * <p> Default value: DEFAULT_NS
     */
    String TENANT_NAMESPACE = "TENANT_NS";

    /**
     * Resource version.
     */
    String TENANT_RESOURCE_VERSION = "RESOURCE_VERSION";

    /**
     * Resource code.
     */
    String TENANT_RESOURCE_CODE = "resource_code";

    /**
     * For definition model resource
     */
    @interface WithResource {

        /**
         * Resource version
         */
        String version();

        /**
         * Resource code
         */
        String code();

    }

}
