package com.bootamp.demo.demo_coin_app.util;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomTimestampDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, 
          DeserializationContext context) throws IOException {
        String timestamp = jsonParser.getText();
        Instant instant = Instant.parse(timestamp); // Assuming the timestamp is in ISO-8601 format
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Hong_Kong"));
        return LocalDateTime.parse(timestamp); // Assuming the timestamp is in ISO-8601 format
    }
}
