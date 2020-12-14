package com.petstore.data.reposiitory;

import com.petstore.data.models.Gender;
import com.petstore.data.models.Pet;
import com.petstore.data.models.Store;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class PetRepositoryTest {
    @Autowired
    PetRepository petRepository;

    @Autowired
    StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void whenPetIsSaved_ReturnAPetId(){
        //create an instance of a pet
        Pet pet = new Pet();
        pet.setName("Ernest");
        pet.setAge(2);
        pet.setBreed("Human");
        pet.setColor("Red");
        pet.setGender(Gender.MALE);
        log.info("Pet instance before saving --> {}", pet);
        petRepository.save(pet);
//        logger.info(pet.toString());

        log.info("Pet instance after saving --> {}", pet);

//        assertNotNull(pet);

        assertThat(pet.getId()).isNotNull();
        //call repository )save method
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void whenStoreIsMappedToPetThenForeignKeyIsPresent(){
        Pet pet = new Pet();
        pet.setName("Lily");
        pet.setAge(1);
        pet.setColor("brown");
        pet.setGender(Gender.FEMALE);
        pet.setBreed("Rotweiller");

        log.info("Pet instance before adding store --> {}", pet);

        Store store = new Store();
        store.setLocation("Lagos");
        store.setName("Semicolon");
        store.setContact("000100");

        log.info("Pet instance before saving --> {}", pet);
        pet.setStore(store);

        petRepository.save(pet);
        log.info("Pet instance after saving --> {}", pet);

        assertThat(pet.getId()).isNotNull();
        assertThat(store.getId()).isNotNull();
        assertThat(pet.getStore()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void whenIAddPetToAStoreICanFetchAllPetsInTheStore(){
        Store store = new Store();
        store.setLocation("Lagos");
        store.setName("Semicolon");
        store.setContact("000100");

        Pet lili = new Pet();
        lili.setName("Lily");
        lili.setAge(1);
        lili.setColor("brown");
        lili.setGender(Gender.FEMALE);
        lili.setBreed("Rotweiller");
        lili.setStore(store);

        petRepository.save(lili);


        Pet lolo = new Pet();
        lolo.setName("Lolo");
        lolo.setAge(1);
        lolo.setColor("brown");
        lolo.setGender(Gender.MALE);
        lolo.setBreed("Cat");
        lolo.setStore(store);

        petRepository.save(lolo);


//        log.info("Pet instance before adding store --> {}", lili, lolo);
//        log.info("Pet instance before saving --> {}", lili, lolo);
        assertThat(lili.getId()).isNotNull();
        assertThat(lolo.getId()).isNotNull();
        assertThat(store.getId()).isNotNull();
        storeRepository.save(store);
        log.info("Pet instance after saving --> {}", store);
    }

    @Test
    void whenFindAllPetsIsCalledThenReturnAllPetsInStore(){
        List<Pet> savedPets = petRepository.findAll();

        log.info("fetched pets list from db --> {}", savedPets);

        assertThat(savedPets).isNotEmpty();
        assertThat(savedPets.size()).isEqualTo(5);
    }

    @Test
    void updatePet(){
        Pet pet = petRepository.findById(32).get();
        log.info("--> {}", pet);

        assertThat(pet).isNotNull();

        pet.setBreed("cow");
        petRepository.save(pet);
        assertThat(pet.getBreed()).isEqualTo("cow");
    }

    @Test
    @Rollback(value = false)
    void whenIDeletePetFromDatabasePetIsDeleted(){
        assertThat(petRepository.existsById(22)).isTrue();

        petRepository.deleteById(22);
        assertThat(petRepository.existsById(22)).isFalse();
    }

}