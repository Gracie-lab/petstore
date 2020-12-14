package com.petstore.service.store;

import com.petstore.data.models.Pet;
import com.petstore.data.models.Store;

import java.util.List;

public interface StoreService {
    Store createStore(StoreDto storeDto) throws Exception;
    Store saveStore(Store store);
    Store updateStore(Store store);
    Store findStoreById(Integer id);
    void deleteStoreById(Integer id);
    Store addPetToStore(Pet pet, Integer storeId) throws Exception;
    List<Store> findAllStore();
    Store deletePetFromStore(Integer petId, Integer storeId) throws Exception;
}
