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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.starthing.standard.FormatStandard;
import com.starthing.standard.ResourceStandard;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model for order detail.
 *
 * <p> Used for order notification or order query capability.
 *
 * <p> order creation
 * {@code
 * {
 * "business_number": "1765662966239199233"/1765662966239199233,
 * "transaction_number": "1765662966255976400"/1765662966255976400,
 * "product_number": "SERVICE_PROVIDER",
 * "product_ability_code": "QRIS",
 * "out_trade_number": "311121311112111221231",
 * "payment_amount": 10.00,
 * "payment_state": "TRANSACTION_PROCESSING",
 * "secure_token": "#{token}"
 * }
 * }
 * <p/>
 *
 * <p> order query
 * {@code
 * {
 * "business_number": "1765662966239199233"/1765662966239199233,
 * "transaction_number": "1765662966255976400"/1765662966255976400,
 * "product_number": "SERVICE_PROVIDER",
 * "product_ability_code": "QRIS",
 * "out_trade_number": "311121311112111221231",
 * "payment_amount": 10.00,
 * "payment_state": "TRANSACTION_PROCESSING",
 * "channel_trade_number": "payermax_prod",
 * "third_trade_number": "e11fbbac-af26-488f-831a-758636c6cb19",
 * "transaction_completed_at": "2024-03-07 10:42:34"
 * }
 * }
 * <p/>
 *
 * <p> order notification:
 * {@code
 * {
 * "business_number": "1765662966239199233"/1765662966239199233,
 * "transaction_number": "1765662966255976400"/1765662966255976400,
 * "product_number": "SERVICE_PROVIDER",
 * "product_ability_code": "QRIS",
 * "out_trade_number": "311121311112111221231",
 * "payment_amount": 10.00,
 * "payment_state": "TRANSACTION_PROCESSING",
 * "channel_trade_number": "payermax_prod",
 * "third_trade_number": "e11fbbac-af26-488f-831a-758636c6cb19",
 * "transaction_completed_at": "2024-03-07 10:42:34",
 * "callback_payload": ""
 * }
 * }
 * <p/>
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "unified.pay.query")
public final class OrderDetailModel implements Serializable {

    /**
     * Business number of order.
     *
     * <p> Json field: business_number
     */
    private final String businessNumber;

    /**
     * Transaction number of order.
     *
     * <p> Json field: transaction_number
     */
    private final String transactionNumber;

    /**
     * Product number of order.
     *
     * <p> Json field: product_number
     */
    private final String productNumber;

    /**
     * Product ability code of order.
     *
     * <p> Json field: product_ability_code
     */
    private final String productAbilityCode;

    /**
     * Out transaction number of order.
     *
     * <p> Json field: out_trade_number
     */
    private final String outTransactionNumber;

    /**
     * Payment amount of order.
     *
     * <p> Json field: payment_amount
     */
    private final BigDecimal paymentAmount;

    /**
     * Payment state of order.
     *
     * <p> Json field: payment_state
     */
    private final OrderStatusEnum paymentState;

    /**
     * Secret token of order. this parameter only return with order creation capability.
     *
     * <p> Json field: secure_token
     */
    private final String secretToken;

    /**
     * Channel transaction number of order from channel partner.
     *
     * <p> Json field: channel_trade_number
     */
    @Nullable
    private final String channelTransactionNumber;

    /**
     * Third transaction number of order from channel partner.
     *
     * <p> Json field: third_trade_number
     */
    @Nullable
    private final String thirdTransactionNumber;

    /**
     * Order completion time with UTC zone-id.
     *
     * <p> Json field: transaction_completed_at
     */
    @Nullable
    private final LocalDateTime transactionCompletionTime;

    /**
     * Notification callback. This parameter only return with order notification capability.
     *
     * <p> Json field: callback_payload
     *
     * @see com.starthing.model.subscription.OrderSubscriptionModel#getNotificationPayload()
     */
    @Nullable
    private final String callbackPayload;

    @JsonCreator
    public OrderDetailModel(
            @JsonProperty("business_number") String businessNumber,
            @JsonProperty("transaction_number") String transactionNumber,
            @JsonProperty("product_number") String productNumber,
            @JsonProperty("product_ability_code") String productAbilityCode,
            @JsonProperty("out_trade_number") String outTransactionNumber,
            @JsonProperty("payment_amount") BigDecimal paymentAmount,
            @JsonProperty("payment_state") OrderStatusEnum paymentState,
            @JsonProperty("secure_token") String secretToken,
            @Nullable @JsonProperty("channel_trade_number") String channelTransactionNumber,
            @Nullable @JsonProperty("third_trade_number") String thirdTransactionNumber,
            @Nullable @JsonProperty("transaction_completed_at") @JsonFormat(pattern = FormatStandard.STANDARD_DATETIME_FORMAT) LocalDateTime transactionCompletionTime,
            @Nullable @JsonProperty("callback_payload") String callbackPayload
    ) {
        this.businessNumber = businessNumber;
        this.transactionNumber = transactionNumber;
        this.productNumber = productNumber;
        this.productAbilityCode = productAbilityCode;
        this.outTransactionNumber = outTransactionNumber;
        this.paymentAmount = paymentAmount;
        this.paymentState = paymentState;
        this.secretToken = secretToken;
        this.channelTransactionNumber = channelTransactionNumber;
        this.thirdTransactionNumber = thirdTransactionNumber;
        this.transactionCompletionTime = transactionCompletionTime;
        this.callbackPayload = callbackPayload;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getProductAbilityCode() {
        return productAbilityCode;
    }

    public String getOutTransactionNumber() {
        return outTransactionNumber;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public OrderStatusEnum getPaymentState() {
        return paymentState;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public @Nullable String getChannelTransactionNumber() {
        return channelTransactionNumber;
    }

    public @Nullable String getThirdTransactionNumber() {
        return thirdTransactionNumber;
    }

    public @Nullable LocalDateTime getTransactionCompletionTime() {
        return transactionCompletionTime;
    }

    public @Nullable String getCallbackPayload() {
        return callbackPayload;
    }

    @Override
    public String toString() {
        return "OrderDetailModel{" +
                "businessNumber='" + businessNumber + '\'' +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", productAbilityCode='" + productAbilityCode + '\'' +
                ", outTransactionNumber='" + outTransactionNumber + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentState=" + paymentState +
                ", secretToken='" + secretToken + '\'' +
                ", channelTransactionNumber='" + channelTransactionNumber + '\'' +
                ", thirdTransactionNumber='" + thirdTransactionNumber + '\'' +
                ", transactionCompletionTime=" + transactionCompletionTime +
                ", callbackPayload='" + callbackPayload + '\'' +
                '}';
    }
}
