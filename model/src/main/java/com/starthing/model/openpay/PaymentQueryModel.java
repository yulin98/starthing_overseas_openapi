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

import java.io.Serializable;

/**
 * Model for payment query.
 *
 * <p>
 * {@code
 *      {
 *          "out_trade_number": "123123111133112331121wqsdsa",
 *      }
 * }
 * <p/>
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public final class PaymentQueryModel implements Serializable {

    /**
     * Out transaction number of order.
     *
     * <p> Json field: out_trade_number
     */
    private final String outTransactionNumber;

    public PaymentQueryModel(String outTransactionNumber) {
        this.outTransactionNumber = outTransactionNumber;
    }

    public String getOutTransactionNumber() {
        return outTransactionNumber;
    }

    @Override
    public String toString() {
        return "PaymentQueryModel{" +
                "outTransactionNumber='" + outTransactionNumber + '\'' +
                '}';
    }
}
