package com.org.functional;

import com.org.TestBase;
import com.org.model.DeletePetResponse;
import com.org.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.org.model.Pet.aPet;

public class DeleteTest extends TestBase {

    private Pet petToDelete;

    @BeforeEach
    void checkoutPet() {
        petToDelete = petService.checkoutPet(aPet().withName("Laid Back Dog"));
    }

    @Test
    void aDeleteTest() {
        DeletePetResponse deletePetResponse = petService.deletePet(petToDelete.getId());

        //TODO - Assert deletePetResponse
    }
}
