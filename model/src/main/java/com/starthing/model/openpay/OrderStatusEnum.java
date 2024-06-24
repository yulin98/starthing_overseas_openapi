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

package com.starthing.model.openpay;

/**
 * Enum for payment transaction state
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public enum OrderStatusEnum {

    /**
     * Processing/waiting transaction state
     */
    TRANSACTION_PROCESSING("TRANSACTION_PROCESSING"),

    /**
     * Paid transaction state
     */
    TRANSACTION_PAID("TRANSACTION_PAID"),

    /**
     * Failure transaction state
     */
    TRANSACTION_FAILED("TRANSACTION_FAILED"),

    /**
     * Closure order state
     */
    TRANSACTION_CLOSED("TRANSACTION_CLOSED"),

    /**
     * Unknown state.
     *
     * <p> Usually will not return this state.
     */
    TRANSACTION_UNKNOWN("TRANSACTION_UNKNOWN");

    /**
     * Real state
     */
    private final String real;

    OrderStatusEnum(String real) {
        this.real = real;
    }

    public String getReal() {
        return real;
    }

    @Override
    public String toString() {
        return "OrderStatusEnum{" +
                "real='" + real + '\'' +
                '}';
    }
}
