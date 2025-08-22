package com.immigration.rcs.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class JsonKeySearcher {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Optional<JsonNode> findValueByKey(String jsonString, String targetKey) {
        try {
            JsonNode root = objectMapper.readTree(jsonString);
            return findValueByKey(root, targetKey);
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    private static Optional<JsonNode> findValueByKey(JsonNode node, String targetKey) {
        if (node == null) return Optional.empty();

        if (node.has(targetKey)) {
            return Optional.ofNullable(node.get(targetKey));
        }

        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            Set<Map.Entry<String, JsonNode>> fields = objectNode.properties(); // modern alternative

            for (Map.Entry<String, JsonNode> entry : fields) {
                Optional<JsonNode> result = findValueByKey(entry.getValue(), targetKey);
                if (result.isPresent()) return result;
            }
        } else if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                Optional<JsonNode> result = findValueByKey(arrayItem, targetKey);
                if (result.isPresent()) return result;
            }
        }

        return Optional.empty();
    }
}
