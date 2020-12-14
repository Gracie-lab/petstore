package com.petstore.service.store;

import com.petstore.data.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreDtoMapper {

    Store store = new Store();
    public Store mapStoreDtoToStore(StoreDto storeDto){
        store.setName(storeDto.getName());
        store.setContact(storeDto.getContact());
        store.setLocation(storeDto.getLocation());
        store.setId(storeDto.getId());
        return store;
    }
}
