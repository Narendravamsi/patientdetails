package com.mapping.controller;

import com.mapping.entity.Patient;
import com.mapping.patient.dto.DeletePatient;
import com.mapping.patient.dto.PatientDetailsWithAddress;
import com.mapping.repository.PatientRepository;
import com.mapping.service.PatientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientDetailsService service;
    @Autowired
    private PatientRepository repos;



    @GetMapping("/fetch/data")
    public List<Patient> fetchAllDetails() {

        return service.fetchAllDetails();

    }
@RequestMapping(method = RequestMethod.POST,path="/insert/data")
    public Patient insertAll(@RequestBody Patient patientdetails){

    return service.addAllDetails(patientdetails);
    }
    @PostMapping(value = "/insert/details",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody PatientDetailsWithAddress patientDetail){
    return service.createUser(patientDetail);
    }


    @DeleteMapping(value = "/delete/{patientId}")
    public DeletePatient deletePatientDetails(@PathVariable Integer patientId){
        return service.deletePatientDetails(patientId);

    }


    public boolean verifyUser(Integer patientId){

        boolean exist=repos.existsById(patientId);
        System.out.println(exist);

        return exist;




    }


}
