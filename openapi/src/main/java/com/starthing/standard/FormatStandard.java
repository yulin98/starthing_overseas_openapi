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

import java.nio.charset.Charset;
import java.time.format.DateTimeFormatter;

/**
 * Standard for format
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
public interface FormatStandard {

    /**
     * Standard charset
     */
    String CHARSET_STRING = "UTF-8";

    /**
     * Standard charset
     */
    Charset CHARSET = Charset.forName(CHARSET_STRING);

    /**
     * Format: standard date time
     */
    String STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Formatter: standard date time
     */
    DateTimeFormatter STANDARD_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(STANDARD_DATETIME_FORMAT);

}
