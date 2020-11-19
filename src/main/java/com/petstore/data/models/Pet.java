package com.petstore.data.models;


import lombok.Data;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    private Integer age;
    private String color;


    private String breed;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Store store;



}
