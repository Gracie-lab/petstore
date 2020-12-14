package com.petstore.service.pet;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class PetDto {
    private String name;
    private String breed;
    private Integer age;
    private String color;
}
