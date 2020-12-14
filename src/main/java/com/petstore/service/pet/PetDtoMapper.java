package com.petstore.service.pet;

import com.petstore.data.models.Pet;
import org.springframework.stereotype.Service;

@Service
public class PetDtoMapper {
    Pet pet;

    void mapDtoToPet(PetDto petDto){
        if(petDto.getName() != null){
            pet.setName(petDto.getName());
        }
        if(petDto.getAge() != null){
            pet.setAge(petDto.getAge());
        }
        if(petDto.getBreed() != null){
            pet.setBreed(petDto.getBreed());
        }
        if(petDto.getColor() != null){
            pet.setColor(petDto.getColor());
        }
    }

}
