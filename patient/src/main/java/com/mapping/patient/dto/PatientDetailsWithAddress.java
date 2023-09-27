package com.mapping.patient.dto;

import com.mapping.entity.InsertAddressEntity;
import com.mapping.entity.InsertPatientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailsWithAddress {

    private InsertAddressEntity insertAddress;
    private InsertPatientEntity insertPatient;

}
