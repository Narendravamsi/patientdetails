package com.mapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient_details")
public class InsertPatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patients_sequ")
    @SequenceGenerator(name = "patients_sequ", sequenceName = "patients_sequ", allocationSize = 1)
    @Column(name="patient_id")
    private int patientId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="mobile_no")
    private long mobileNumber;

    @Column(name="gender")
    private String gender;
    @Column(name="email_Id")
    private String emailId;

    @Column(name="password")
    private String password;

    @Column(name="confirm_password")
    private String confirmPassword;



}
