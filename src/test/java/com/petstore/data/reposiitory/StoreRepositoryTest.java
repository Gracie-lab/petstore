package com.petstore.data.reposiitory;

import com.petstore.data.models.Pet;
import com.petstore.data.models.Store;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class StoreRepositoryTest {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    PetRepository petRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void storeHasIdWhenSaved(){
        Store store = new Store();

        store.setName("petsHouse");
        store.setContact("0231987654");
        store.setLocation("Ikoyi");
        log.info("Store before saving --> {}", store);

        storeRepository.save(store);
        log.info("Store after saving --> {}", store);

        assertThat(store.getId()).isNotNull();
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void whenIinsertStoresIntoDbICanFindThen(){
        Store store = storeRepository.findById(3).orElse(null);
        log.info("Store with id 3 --> {}", store);
        assertThat(store).isNotNull();
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void updateStoreInDbWhenIUpdatestore(){
        Store store = storeRepository.findById(4).orElse(null);
        log.info("Store before update --> {}", store);

        store.setName("animal store");
        storeRepository.save(store);

        log.info("Store after update --> {}", store);

        assertThat(store.getName()).isEqualTo("animal store");
    }


    @Test
    void deleteStoreInDbWhenIDeleteFromRepo(){

        assertThat(storeRepository.existsById(4)).isTrue();
        storeRepository.deleteById(4);

        assertThat(storeRepository.existsById(4)).isFalse();
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void testThatICanFindALlPetsForAStore(){
        Store store = storeRepository.findById(2).orElse(null);
//        Pet pet = petRepository.findById(22).orElse(null);
        assert store != null;
        List<Pet> petsInStore = store.getPets();

        log.info("Pets in store --> {}", petsInStore);
        assertThat(petRepository.findById(22).orElse(null)).isIn(petsInStore);
    }

}