package com.petstore.web.controller.pet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.data.models.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PetRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

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

//        ObjectMapper mapper = new ObjectMapper();


        this.mockMvc.perform(post("/pet/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(pet)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }


    @Test
    void whenICallTheGetPetMethodThenGetAPetObject() throws Exception {

        this.mockMvc.perform(get("/pet/getPet"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//
//                .content(mapper.writeValueAsString(pet)))

    }

    @Test
    void deletePetApiWorks() throws Exception {
        this.mockMvc.perform(delete("/pet/deletePet/32"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}