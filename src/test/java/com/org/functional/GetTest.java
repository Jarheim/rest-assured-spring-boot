package com.org.functional;

import com.org.TestBase;
import com.org.model.Pet;
import com.org.model.Status;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetTest extends TestBase {

    @Test
    void aGetTest() {
        List<Pet> pets = petService.getPets(Status.sold);

        //TODO - Assert petResponse
    }
}
