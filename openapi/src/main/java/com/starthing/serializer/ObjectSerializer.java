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

package com.starthing.serializer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Object serializable
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
public interface ObjectSerializer {

    /**
     * Default serializer
     */
    ObjectSerializer SERIALIZER = spi(null);

    /**
     * Default charset
     */
    Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * Serialize instance to array of bytes
     *
     * @param instance Instance target
     * @return Serialized data
     * @throws SerializerException if serialized failed, will throwable SerializableException
     */
    byte[] serialize(Object instance);

    /**
     * Deserialize array of bytes to object
     *
     * @param bytes Content data
     * @param type  Type of instance
     * @param <T>   Generic type of instance
     * @return Instance of type
     * @throws SerializerException if bytes is empty, will throwable this error
     * @throws SerializerException if deserialized failed or instantiate object failed, will throwable this error
     */
    <T> T deserialize(byte[] bytes, Class<T> type);

    /**
     * Reade array of bytes to node tree
     *
     * @param bytes Serialized data
     * @return node tree
     * @throws SerializerException if deserialized failed or instantiate object failed, will throwable this error
     */
    ObjectNode tree(byte[] bytes);

    /**
     * Reade array of bytes to node tree
     *
     * @param bytes Serialized data
     * @return node tree
     * @throws SerializerException if deserialized failed or instantiate object failed, will throwable this error
     */
    ArrayNode trees(byte[] bytes);

    /**
     * Reade Object to node tree
     *
     * @param instance Serialized data
     * @return node tree
     * @throws SerializerException  if deserialized failed or instantiate object failed, will throwable this error
     * @throws NullPointerException when input null, will throwable this error
     */
    ObjectNode tree(Object instance);

    /**
     * Convert tree tree to object
     *
     * @param tree tree tree
     * @param type object type
     * @param <T>  generic type of object
     * @return converted object
     */
    <T> T tree(ObjectNode tree, Class<T> type);

    /**
     * Create empty tree
     *
     * @return node tree
     */
    ObjectNode createNode();

    /**
     * Spi loader
     */
    static ObjectSerializer spi(@Nullable ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }

        // service loader
        final ServiceLoader<ObjectSerializer> serviceLoader = ServiceLoader.load(ObjectSerializer.class, classLoader);
        // iterator
        final Iterator<ObjectSerializer> iterator = serviceLoader.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }

        throw new IllegalArgumentException("Can't load @ObjectSerializer implementation.");
    }

    /**
     * Exception for when serialize failure.
     */
    final class SerializerException extends RuntimeException {

        public SerializerException(String message) {
            super(message);
        }

        public SerializerException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
