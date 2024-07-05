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

import com.starthing.model.openpay.OrderDetailModel;
import com.starthing.model.openpay.PaymentQueryModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * todo: what are capabilities in this class. and plz introduction of this class
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
class StarThingApiTest {

    @Test
    void request() {
        StarThingApi api = StarThingApi.create();

        final PaymentQueryModel queryModel = new PaymentQueryModel("962956837378985984");
        final OrderDetailModel orderDetail = api.request(ITenantNamespace.of("1178794035840671744", "szlyxkeefrel024lnvwjb1dfu53nwjw83ywvn0999uqbzlwww1r02wuopkoztygx"), queryModel).toCompletableFuture().join();
        assertNotNull(orderDetail);

        System.out.println(orderDetail);
    }
}