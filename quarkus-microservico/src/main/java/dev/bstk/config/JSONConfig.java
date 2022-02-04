package dev.bstk.config;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.json.bind.JsonbConfig;

public class JSONConfig implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig jsonbConfig) {
        jsonbConfig.withNullValues(null);
    }

}
