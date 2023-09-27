package com.mapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient_address")
public class InsertAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_addr_seq")
    @SequenceGenerator(name = "patient_addr_seq", sequenceName = "patient_addr_seq", allocationSize = 1)
    @Column(name="patient_address_id")
    private int AddressId;

    @Column(name="village")
    private String village;

    @Column(name="house_number")
    private String houseNumber;

    @Column(name="mandal")
    private String mandal;

    @Column(name="district")
    private String district;

    @Column(name="city")
    private String city;

    @Column(name="pin_code")
    private long pinCode;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="patient_id")
    private int patientId;


}
