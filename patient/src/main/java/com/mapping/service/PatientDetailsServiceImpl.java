package com.mapping.service;

import com.mapping.controller.PatientController;
import com.mapping.entity.InsertAddressEntity;
import com.mapping.entity.InsertPatientEntity;
import com.mapping.entity.Patient;
import com.mapping.patient.dto.DeletePatient;
import com.mapping.patient.dto.PatientDetailsWithAddress;
import com.mapping.repository.InsertAddressRepository;
import com.mapping.repository.InsertPatientRepository;
import com.mapping.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {
    @Autowired
    private PatientRepository repo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private InsertPatientRepository patientRepo;

    @Autowired
    private InsertAddressRepository addressRepo;






    @Override
    public String createUser(PatientDetailsWithAddress patientDetail) {

        try {

            String password1 = patientDetail.getInsertPatient().getPassword();
            String password2 = patientDetail.getInsertPatient().getConfirmPassword();
            System.out.println(password2);
            System.out.println(password1);

            if (password1.equals(password2)) {

                InsertPatientEntity patient = patientDetail.getInsertPatient();
                InsertAddressEntity address = patientDetail.getInsertAddress();
                patientRepo.save(patient);
                address.setPatientId(patient.getPatientId());
                addressRepo.save(address);

                return "Data is inserted successfully";

            } else {
              return "please enter correct password";
            }

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }


    }

    @Override
    public DeletePatient deletePatientDetails(Integer patientId) {
     /*PatientController patientIsExist= new PatientController();

      boolean isExist=  patientIsExist.verifyUser(patientId);
      System.out.println(isExist);*/
        boolean isExist=repo.existsById(patientId);

        if (isExist){
            repo.deleteById(patientId);

            DeletePatient deletePatient= new DeletePatient();

            deletePatient.setPatientId(patientId);
            deletePatient.setMessage("your data is deleted");

            return deletePatient;

        }else {
            DeletePatient deletePatient= new DeletePatient();

            deletePatient.setPatientId(patientId);
            deletePatient.setMessage("your patient id not found");
            return deletePatient ;

        }

    }


    @Override
    public List<Patient> fetchAllDetails() {

        return repo.findAll();
    }

    @Override
    public Patient addAllDetails(Patient patientdetails) {
        return null;
    }



    /*@Override
    public List<PatientResponse> loadAllDetails() {

       List<PatientResponse> patientList=new ArrayList<>();

      List<Patient>   patients= (List<Patient>) repo.findAll();

      for(Patient patient:patients){
          PatientResponse patientResponse= new PatientResponse();

          patientResponse.setPatientId(patient.getPatientId());
          patientResponse.setAddressResponseList(patient.get);
      }






        return null;
    }*/



}
