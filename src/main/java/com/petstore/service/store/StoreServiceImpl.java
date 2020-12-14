package com.petstore.service.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.data.models.Pet;
import com.petstore.data.models.Store;
import com.petstore.data.reposiitory.StoreRepository;
import com.petstore.service.pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
@Autowired
StoreDtoMapper storeDtoMapper;

    @Autowired
    PetService petService;

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store createStore(StoreDto storeDto) throws Exception {
        Store store = findStoreById(storeDto.getId());
        if(store != null){
            throw new Exception("Store exists already");
        }
        else{
            Store newStore = storeDtoMapper.mapStoreDtoToStore(storeDto);
            return saveStore(newStore);
        }

    }

    @Override
    public Store saveStore(Store store) {
        if(store == null){
            throw new NullPointerException("Pet object cannot be null");
        }
        return storeRepository.save(store);
    }

    @Override
    public Store updateStore(Store store) {
        return null;
    }

    @Override
    public Store findStoreById(Integer id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStoreById(Integer id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<Store> findAllStore() {
        return storeRepository.findAll();
    }

    @Override
    public Store deletePetFromStore(Integer petId, Integer storeId) throws Exception {
        Store store = findStoreById(storeId);
        List<Pet> petsInStore =    store.getPets();

        if(petService.findPetById(petId) == null){
            throw new Exception("Pet does not exist");
        }else {
            for (Pet eachPet : petsInStore) {
                if (petId.equals(eachPet.getId())) {
                    petsInStore.remove(petService.findPetById(petId));
                    store.setPets(petsInStore);
                    saveStore(store);
                }
            }
        }
        return store;
    }

    @Override
    public Store addPetToStore(Pet pet, Integer storeId) throws Exception{
        if (!storeRepository.existsById(storeId)){
            throw new Exception("Store does not exist");
        }
        else{
            Store store = storeRepository.findById(storeId).orElse(null);
            assert store != null;
            store.getPets().add(pet);
//            store.addPets(pet);
            return store;
        }
    }
}
