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

/**
 * Error exception interface
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
public interface ErrorCode {

    /**
     * Error code
     */
    String getErrorCode();

    /**
     * Error message
     */
    String getErrorMessage();

    /**
     * Check is client error
     */
    default boolean isClient() {
        return getErrorCode() != null && getErrorCode().startsWith("client");
    }

    /**
     * Check is internal error
     */
    default boolean isInternal() {
        return getErrorCode() != null && getErrorCode().startsWith("internal");
    }

    /**
     * Check is external error
     */
    default boolean isExternal() {
        return getErrorCode() != null && getErrorCode().startsWith("external");
    }

    /**
     * Create error instance
     *
     * @param errorCode    error code
     * @param errorMessage error message
     * @return instance
     */
    static ErrorCode of(String errorCode, String errorMessage) {
        return new ErrorCodeSupport(errorCode, errorMessage);
    }

    /**
     * Client error exception
     */
    interface ClientError extends ErrorCode {

    }

    /**
     * Internal error exception
     */
    interface InternalError extends ErrorCode {

    }

    /**
     * External error exception
     */
    interface ExternalError extends ErrorCode {

    }

    /**
     * Code support
     */
    final class ErrorCodeSupport implements ErrorCode.ClientError, ErrorCode.InternalError, ErrorCode.ExternalError {

        /**
         * Error code
         */
        private final String errorCode;

        /**
         * Error message
         */
        private final String errorMessage;

        ErrorCodeSupport(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        @Override
        public String getErrorCode() {
            return this.errorCode;
        }

        @Override
        public String getErrorMessage() {
            return this.errorMessage;
        }
    }


}
