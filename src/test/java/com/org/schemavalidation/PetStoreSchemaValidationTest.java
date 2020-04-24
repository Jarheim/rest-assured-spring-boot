package com.org.schemavalidation;

import com.org.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PetStoreSchemaValidationTest extends TestBase {

    /**
     * Validates that the JSON document for GET pets conforms to the JSON schema for GET pets
     */
    @Test
    void aSchemaValidationTest() {
        petService.getPets()
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema/petResponse.json"));
    }
}
