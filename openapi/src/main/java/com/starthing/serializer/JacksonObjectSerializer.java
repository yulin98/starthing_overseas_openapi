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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Default object serializer by jackson for json protocol
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2023/08/02
 */
public final class JacksonObjectSerializer implements ObjectSerializer {

    /**
     * Jackson object serializer for json protocol
     */
    private static final ObjectMapper SERIALIZER = createSerializer();

    /**
     * Create jackson mapper
     */
    private static ObjectMapper createSerializer() {
        final ObjectMapper mapper = new ObjectMapper();

        // register time module
        final JavaTimeModule timeModule = new JavaTimeModule();

        mapper.registerModule(timeModule);

        return mapper;
    }

    public JacksonObjectSerializer() {
    }

    @Override
    public byte[] serialize(Object obj) {
        try {
            return SERIALIZER.writeValueAsString(obj).getBytes(CHARSET);
        } catch (JsonProcessingException ex) {
            throw new SerializerException(ex.getMessage());
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) {
        try {
            return SERIALIZER.readValue(new String(bytes, CHARSET), type);
        } catch (JsonProcessingException ex) {
            throw new SerializerException(ex.getMessage());
        }
    }

    @Override
    public ObjectNode tree(byte[] bytes) {
        try {
            final JsonNode jsonNode = SERIALIZER.readTree(bytes);
            if (jsonNode instanceof ArrayNode) {
                throw new SerializerException("tree array is not supported. should use {@link #trees(@byte[])}.");
            }

            return (ObjectNode) jsonNode;
        } catch (IOException exception) {
            throw new SerializerException(exception.getMessage());
        }
    }

    @Override
    public ArrayNode trees(byte[] bytes) {
        try {
            final JsonNode jsonNode = SERIALIZER.readTree(bytes);
            if (jsonNode instanceof ArrayNode) {
                return (ArrayNode) jsonNode;
            }

            throw new SerializerException("tree is not supported. should use {@link #tree(@byte[])}.");
        } catch (IOException exception) {
            throw new SerializerException(exception.getMessage());
        }
    }

    @Override
    public ObjectNode tree(Object instance) {
        if (instance == null) {
            throw new NullPointerException("instance must not be null.");
        }

        try {
            return SERIALIZER.valueToTree(instance);
        } catch (IllegalArgumentException ex) {
            throw new SerializerException(ex.getMessage());
        }
    }

    @Override
    public <T> T tree(ObjectNode tree, Class<T> type) {
        try {
            return SERIALIZER.treeToValue(tree, type);
        } catch (JsonProcessingException ex) {
            throw new SerializerException(ex.getMessage());
        }
    }

    @Override
    public ObjectNode createNode() {
        return SERIALIZER.createObjectNode();
    }

}
