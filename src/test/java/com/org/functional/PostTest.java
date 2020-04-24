package com.org.functional;

import com.org.TestBase;
import com.org.model.Pet;
import org.junit.jupiter.api.Test;

import static com.org.model.Pet.aPet;

class PostTest extends TestBase {

    @Test
    void aPostTest() {
        Pet petRequest = aPet()
                .withName("Laid Back Dog");

        Pet petResponse = petService.checkoutPet(petRequest);

        //TODO Assert petResponse
    }
}
