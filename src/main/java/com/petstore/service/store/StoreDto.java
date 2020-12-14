package com.petstore.service.store;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class StoreDto {
    private String name;
    private String contact;
    private String location;
    private Integer id;
}
