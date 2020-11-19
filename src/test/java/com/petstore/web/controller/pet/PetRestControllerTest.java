package com.petstore.web.controller.pet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.data.models.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PetRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenICallTheCreatePostMethodThenCreateAPetObject() throws Exception {
        Pet pet = new Pet();
        pet.setName("Sili");
        pet.setColor("black");
        pet.setBreed("dog");
        pet.setAge(3);

        ObjectMapper mapper = new ObjectMapper();


        this.mockMvc.perform(post("/pet/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(pet)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }
}