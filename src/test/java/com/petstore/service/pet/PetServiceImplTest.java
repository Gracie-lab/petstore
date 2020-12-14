package com.petstore.service.pet;

import com.petstore.data.models.Pet;
import com.petstore.data.reposiitory.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceImplTest {

   //create a mock of repository and inject it into the service

    @Mock
    PetRepository petRepository;

    @InjectMocks   //mock test annotation
    PetService petService = new PetServiceImpl();

    Pet testPet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testPet = new Pet();
    }

    @Test
    void mockTheSavePetToARepositoryTest(){
        //use when method when testing a method that has a return type
        when(petRepository.save(testPet)).thenReturn(testPet);
        petService.savePet(testPet);
        verify(petRepository, times(1)).save(testPet);
    }

    @Test
    void mockTheFindByIdInRepositoryTest(){
        when(petRepository.findById(2)).thenReturn(Optional.of(testPet));
        petService.findPetById(2);
        verify(petRepository, times(1)).findById(2).orElse(testPet);
    }

    @Test
    void mockTheDeleteByIdTest() throws Exception {
        doNothing().when(petRepository).deleteById(2);
        petService.deletePetById(2);

        verify (petRepository, times(1)).deleteById(2);
    }



}