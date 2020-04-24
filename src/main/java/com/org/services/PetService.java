package com.org.services;

import com.org.config.PetStorePath;
import com.org.model.DeletePetResponse;
import com.org.model.Pet;
import com.org.model.Status;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static io.restassured.RestAssured.given;

@Service
public class PetService {

    @Autowired
    private RequestSpecification requestSpecification;

    @Autowired
    private PetStorePath path;

    /**
     * GET pets
     * Validate that the response status code matches 200
     * Extracts the response (List) as a Java object
     */
    public List<Pet> getPets(Status status) {
        return given(requestSpecification)
                .when()
                .queryParam("status", status.getValue())
                .get(path.getGet())
                .then()
                .statusCode(200)
                .and()
                .extract().jsonPath().getList("", Pet.class);
    }

    /**
     * GET pets
     * Returns Response from rest assured which is used for schema validation in this project
     */
    public Response getPets() {
        return given(requestSpecification)
                .when()
                .queryParam("status", Status.sold.getValue())
                .get(path.getGet());
    }

    /**
     * POST a pet
     * Validate that the response status code matches 200
     * Extracts the response as a Java object
     */
    public Pet checkoutPet(Pet petRequest) {
        return given(requestSpecification)
                .body(petRequest)
                .when()
                .post(path.getPost())
                .then()
                .statusCode(200)
                .and()
                .extract().as(Pet.class);
    }

    /**
     * Creates a URI and setting a uri variable using UriComponentsBuilder from springframework
     * DELETE a pet
     * Validate that the response status code matches 200
     * Extracts the response as a Java object
     */
    public DeletePetResponse deletePet(long petId) {
        URI uri = UriComponentsBuilder.fromPath(path.getDelete()).build(petId);

        return given(requestSpecification)
                .when()
                .delete(uri)
                .then()
                .statusCode(200)
                .and()
                .extract().as(DeletePetResponse.class);
    }
}
