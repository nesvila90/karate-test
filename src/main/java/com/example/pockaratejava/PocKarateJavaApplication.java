package com.example.pockaratejava;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class PocKarateJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocKarateJavaApplication.class, args);
    }

    @GetMapping(value = "api/v2/jeiner", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> dummy() {
        return ResponseEntity.ok(buildDummy());
    }

    private String buildDummy() {
        try {
            Map<String, String> dummy2 = new HashMap<>();
            dummy2.put("code", "dummy2");
            dummy2.put("status", "status 2");
            ObjectMapper objectMapper = new ObjectMapper();
            String dummyString = objectMapper.writeValueAsString(dummy2);
            JsonNode dummy3 = objectMapper.readTree(dummyString);
            Map<String, Object> dummy = new HashMap<>();
            dummy.put("code", "dummy1");
            dummy.put("status", "Hector es un fariseo");
            dummy.put("dayana", "Dayana es un amor");
            dummy.put("payload", dummy3);
            return objectMapper.writeValueAsString(dummy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
