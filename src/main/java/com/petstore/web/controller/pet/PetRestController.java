package com.petstore.web.controller.pet;

import com.petstore.data.models.Pet;
import com.petstore.service.pet.PetDto;
import com.petstore.service.pet.PetService;
import com.petstore.service.pet.PetServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pet")
public class PetRestController {
    @Autowired
    PetService petService;

    @Autowired
    PetDto petDto;

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

    @GetMapping("/getPets")
    public void getAllPets(){
        try{
            petService.findAllPets();
        }
        catch(Exception e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deletePet/{id}")
    public void deletePet(@PathVariable("id") Integer id){
        try{
            petService.deletePetById( id);
        }
        catch(Exception e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/updatePetDetails")
        public ResponseEntity<?> updatePetDetails(Pet pet) throws Exception {
            try{
              petService.updatePetDetails(petDto, pet.getId());
            } catch (Exception exception) {
                return ResponseEntity.badRequest().body(exception.getMessage());
            }
            return ResponseEntity.ok().body(pet);
    }

    @GetMapping("/getPet")
    public ResponseEntity<?> findAllPets(){
        log.info("Get");

        List<Pet> petList = petService.findAllPets();
        return ResponseEntity.ok().body(petList);
    }

    @GetMapping("/one")
    public ResponseEntity<?> fineOnePet(){
        return null;
    }
}
