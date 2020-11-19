package com.petstore.data.reposiitory;

import com.petstore.data.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
  void findByStoreId(Integer store_id);
}
