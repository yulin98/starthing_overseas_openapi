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

import com.starthing.model.subscription.OrderSubscriptionModel;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model for payment creation.
 *
 * <p>
 * {@code
 *      {
 *          "product_number": "SERVICE_PROVIDER",
 *          "product_ability_code": "WECHAT",
 *          "area_code": "CN",
 *          "out_trade_number": "123123111133112331121wqsdsa",
 *          "introduction": "this is a test",
 *          "payment_amount": 0.01,
 *          "expired_time_expression": "30s",
 *          "subscription": {
 *              "notification_method": "HTTP",
 *              "notification_address": "https://www.baidu.com",
 *              "notification_payload":""
 *           }
 *      }
 * }
 * <p/>
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public final class PaymentCreationModel implements Serializable {

    /**
     * Product number.
     *
     * <p> Json field: product_number
     */
    private final String productNumber;

    /**
     * Product ability code.
     *
     * <p> Json field: product_ability_code
     */
    private final String productAbilityCode;

    /**
     * Area code of order.
     *
     * <p> Json field: area_code
     */
    private final String areaCode;

    /**
     * Out transaction number of order.
     *
     * <p> Json field: out_trade_number
     */
    private final String outTransactionNumber;

    /**
     * Introduction of order.
     *
     * <p> Json field: introduction
     */
    private final String introduction;

    /**
     * Payment amount of order.
     *
     * <p> Json field: payment_amount
     */
    private final BigDecimal paymentAmount;

    /**
     * Expiration time of order.
     *
     * <p> Json field: expired_time
     */
    @Nullable
    private final LocalDateTime expiredTime;

    /**
     * Expiration time expression of order.
     *
     * <p> Json field: expired_time_expression
     */
    @Nullable
    private final String expiredTimeExpression;

    /**
     * FallbackUrl for which ability code support web-h5 payment.
     *
     * <p> Json field: fallback_url
     *
     * @deprecated this filed will remove future. we will not provide any ability code for h5 redirect url website payment.
     */
    @Nullable
    @Deprecated
    private final String fallbackUrl;

    /**
     * ReturnUrl for which code support web-h5 payment.
     *
     * <p> Json field: return_url
     *
     * @deprecated this filed will remove future. we will not provide any ability code for h5 redirect url website payment.
     */
    @Nullable
    @Deprecated
    private final String returnUrl;

    /**
     * Subscribe order result.
     */
    private final OrderSubscriptionModel subscription;

    public PaymentCreationModel(String productNumber, String productAbilityCode, String areaCode, String outTransactionNumber, String introduction, BigDecimal paymentAmount, @Nullable LocalDateTime expiredTime, @Nullable String expiredTimeExpression, @Nullable String fallbackUrl, @Nullable String returnUrl, OrderSubscriptionModel subscription) {
        this.productNumber = productNumber;
        this.productAbilityCode = productAbilityCode;
        this.areaCode = areaCode;
        this.outTransactionNumber = outTransactionNumber;
        this.introduction = introduction;
        this.paymentAmount = paymentAmount;
        this.expiredTime = expiredTime;
        this.expiredTimeExpression = expiredTimeExpression;
        this.fallbackUrl = fallbackUrl;
        this.returnUrl = returnUrl;
        this.subscription = subscription;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getProductAbilityCode() {
        return productAbilityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getOutTransactionNumber() {
        return outTransactionNumber;
    }

    public String getIntroduction() {
        return introduction;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public @Nullable LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public @Nullable String getExpiredTimeExpression() {
        return expiredTimeExpression;
    }

    public @Nullable String getFallbackUrl() {
        return fallbackUrl;
    }

    public @Nullable String getReturnUrl() {
        return returnUrl;
    }

    public OrderSubscriptionModel getSubscription() {
        return subscription;
    }

    @Override
    public String toString() {
        return "PaymentCreationModel{" +
                "productNumber='" + productNumber + '\'' +
                ", productAbilityCode='" + productAbilityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", outTransactionNumber='" + outTransactionNumber + '\'' +
                ", introduction='" + introduction + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", expiredTime=" + expiredTime +
                ", expiredTimeExpression='" + expiredTimeExpression + '\'' +
                ", fallbackUrl='" + fallbackUrl + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", subscription=" + subscription +
                '}';
    }
}
