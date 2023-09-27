package com.mapping.service;

import com.mapping.entity.Patient;
import com.mapping.patient.dto.DeletePatient;
import com.mapping.patient.dto.PatientDetailsWithAddress;

import java.util.List;

public interface PatientDetailsService{

  List<Patient> fetchAllDetails();


Patient addAllDetails(Patient patientdetails);


String createUser(PatientDetailsWithAddress patientDetail);


//List<PatientResponse> loadAllDetails();

  DeletePatient deletePatientDetails(Integer patientId);


}
