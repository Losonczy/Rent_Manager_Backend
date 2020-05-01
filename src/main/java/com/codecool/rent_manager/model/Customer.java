package com.codecool.rent_manager.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customers")
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String address;

    private String phone_number;


    @Singular
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @EqualsAndHashCode.Exclude
    private Set<Rent> rents;
}
