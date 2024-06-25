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

package com.starthing.transform.tenant;

import com.starthing.transform.ITenantNamespace;

/**
 * todo: ...
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public final class DefaultTenantNamespace implements ITenantNamespace {

    /**
     * Tenant namespace
     */
    private final String tenantNumber;

    /**
     * Tenant namespace
     */
    private final String tenantNamespace;

    /**
     * Tenant secret code
     */
    private final String tenantSecretCode;

    public DefaultTenantNamespace(String tenantNumber, String tenantNamespace, String tenantSecretCode) {
        this.tenantNumber = tenantNumber;
        this.tenantNamespace = tenantNamespace;
        this.tenantSecretCode = tenantSecretCode;
    }

    @Override
    public String getTenantNumber() {
        return this.tenantNumber;
    }

    @Override
    public String getTenantNamespace() {
        return this.tenantNamespace;
    }

    @Override
    public String getTenantSecretCode() {
        return this.tenantSecretCode;
    }
}
