package com.petstore.service.store;

import com.petstore.data.models.Store;
import com.petstore.data.reposiitory.PetRepository;
import com.petstore.data.reposiitory.StoreRepository;
import com.petstore.service.pet.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class StoreServiceImplTest {

    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreServiceImpl storeService;

    Store store;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        store = new Store();
    }

    @Test
    void mockSaveStoreToRepositoryTest(){
        when(storeRepository.save(store)).thenReturn(store);

        storeService.saveStore(store);
        verify(storeRepository, times(1)).save(store);
    }

//    @Test
//    void mockUpdateStoreInRepositoryTest(){
//        when(storeRepository.)
//    }

    @Test
    void mockFindStoreByIdTest(){
        when(storeRepository.findById(4)).thenReturn(Optional.of(store));

        storeService.findStoreById(4);
        verify(storeRepository, times(1)).findById(4);

    }

    @Test
    void mockDeleteStoreById(){
        doNothing().when(storeRepository).deleteById(3);
        storeService.deleteStoreById(3);
        verify(storeRepository, times(1)).deleteById(3);
    }

    @Test
    void mockFindAllStoresTest(){
        when(storeRepository.findAll()).thenReturn(List.of(store));

        storeService.findAllStore();
        verify(storeRepository, times(1)).findAll();
    }
}