package com.petstore.service.store;

import com.petstore.data.models.Store;
import com.petstore.data.reposiitory.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        return null;
    }

    @Override
    public Store updateStore(Store store) {
        return null;
    }

    @Override
    public Store findStoreById(Integer id) {
        return null;
    }

    @Override
    public void deleteStoreById(Integer id) {

    }

    @Override
    public List<Store> findAllStore() {
        return null;
    }
}
