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

package com.starthing.unirest;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.eclipse.microprofile.rest.client.ext.QueryParamStyle;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * todo: what are capabilities in this class. and plz introduction of this class
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/07/05
 */
public class UnirestRestClientBuilder implements RestClientBuilder {

    /**
     * BaseUrl
     */
    private URL url;

    @Override
    public RestClientBuilder baseUrl(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("url is null");
        }

        this.url = url;
        return this;
    }

    @Override
    public RestClientBuilder connectTimeout(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public RestClientBuilder readTimeout(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public RestClientBuilder executorService(ExecutorService executor) {
        return null;
    }

    @Override
    public RestClientBuilder sslContext(SSLContext sslContext) {
        return null;
    }

    @Override
    public RestClientBuilder trustStore(KeyStore trustStore) {
        return null;
    }

    @Override
    public RestClientBuilder keyStore(KeyStore keyStore, String keystorePassword) {
        return null;
    }

    @Override
    public RestClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier) {
        return null;
    }

    @Override
    public RestClientBuilder followRedirects(boolean follow) {
        return null;
    }

    @Override
    public RestClientBuilder proxyAddress(String proxyHost, int proxyPort) {
        return null;
    }

    @Override
    public RestClientBuilder queryParamStyle(QueryParamStyle style) {
        return null;
    }

    @Override
    public <T> T build(Class<T> clazz) throws IllegalStateException, RestClientDefinitionException {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Proxy.newProxyInstance(classLoader, new Class[]{clazz},)
        return null;
    }
}
