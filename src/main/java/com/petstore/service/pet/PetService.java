package com.petstore.service.pet;

import com.petstore.data.models.Pet;

import java.util.List;

public interface PetService {
    Pet savePet(Pet pet);
    Pet findPetById(Integer id);
    List<Pet> findAllPets();
    void deletePetById(Integer id) throws Exception;
    Pet updatePetDetails(PetDto petDto, Integer id) throws  Exception;
}
