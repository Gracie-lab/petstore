package com.petstore.service.pet;

import com.petstore.data.models.Pet;
import com.petstore.data.reposiitory.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetRepository petRepository;


    @Override
    public Pet savePet(Pet pet) {
        if(pet == null){
            throw new NullPointerException("Pet object cannot be null");
        }
        return petRepository.save(pet);
    }

    @Override
    public Pet findPetById(Integer id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pet> findAllPets() {
        return null;
    }

    @Override
    public void deletePetById(Integer id) {
        petRepository.deleteById(id);
    }
}
