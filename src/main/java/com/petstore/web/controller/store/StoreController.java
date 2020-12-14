package com.petstore.web.controller.store;

import com.petstore.data.models.Pet;
import com.petstore.service.store.StoreDto;
import com.petstore.service.store.StoreService;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/createStore")
    public ResponseEntity<?> createStore(StoreDto storeDto) throws Exception{
        try{
            storeService.createStore(storeDto);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/addPetToStore")
    //@RequestParam(storeId), @RequestParam(petId)
    public ResponseEntity<?> addPetToStore(Pet pet, Integer storeId){
        try{
            storeService.addPetToStore(pet, storeId);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }

    @DeleteMapping("/deletePet")
    public ResponseEntity<?> deletePetFromStore(Integer petId, Integer storeId){
        try{
            storeService.deletePetFromStore(petId, storeId);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }
}
