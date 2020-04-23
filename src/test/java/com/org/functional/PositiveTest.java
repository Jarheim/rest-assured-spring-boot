package com.org.functional;

import com.org.TestBase;
import com.org.model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.org.model.Pet.aPet;
import static io.restassured.RestAssured.given;

class PositiveTest extends TestBase {

    @Test
    void buyADog() {
        Pet pet = aPet()
                .withName("Laid Back Dog");

        Pet response = given(requestSpecification)
                .body(pet)
                .when()
                .post(path.getPost())
                .then()
                .statusCode(200)
                .and()
                .extract().as(Pet.class);
    }
}
