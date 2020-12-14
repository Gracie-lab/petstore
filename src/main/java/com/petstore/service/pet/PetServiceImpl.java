package com.petstore.service.pet;

import com.petstore.data.models.Pet;
import com.petstore.data.reposiitory.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetRepository petRepository;

    @Autowired
    PetDtoMapper petDtoMapper;
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
        return petRepository.findAll();
    }

    @Override
    public void deletePetById(Integer id) throws Exception {
        if(petRepository.findById(id).isEmpty()){
            throw new Exception("Pet does not exist");
        }
        petRepository.deleteById(id);
    }

    @Override
    public Pet updatePetDetails(PetDto petDto, Integer id) throws Exception{
        Pet pet = findPetById(id);
        if(pet == null){
            throw new Exception("Pet object cannot be null");
        }
        petDtoMapper.mapDtoToPet(petDto);
        return pet;
    }
}
