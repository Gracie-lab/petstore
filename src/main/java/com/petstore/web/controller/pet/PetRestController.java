package com.petstore.web.controller.pet;

import com.petstore.data.models.Pet;
import com.petstore.service.pet.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/pet")
public class PetRestController {
    @Autowired
    PetService petService;

    @PostMapping("/create")
    public ResponseEntity<?> savePet(@RequestBody Pet pet){

        //log request body
        log.info("Request object --> {}", pet);
        try{
            petService.savePet(pet);
        }
        catch(NullPointerException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        //save request


        return new ResponseEntity<>(pet, HttpStatus.CREATED);

    }
}
