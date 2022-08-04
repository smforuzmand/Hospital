package dao.implementations;

import dao.PatientDao;
import model.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PatientDaoImpl implements PatientDao {

    List<Patient> patientList;

    @Override
    public Patient create(Patient patient) {
        if (patient == null)
            throw new RuntimeException("null amount for patients is not allowed");
        patientList.add(patient);
        return patient;


    }

    @Override
    public Collection<Patient> findAll() {

        return patientList;
    }

    @Override
    public Patient findById(String id) {
        //for each patient with the Patient type looks up in the patientlist
        for (Patient patient : patientList) {
            // if the patient id equals to id parameter then return patient.
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;

    }

    @Override
    public boolean delete(String id) {
//        for (Patient patient : patientList) {
//            if (patient.getId().equals(id)){
//                return patientList.remove(patient);
//            }

        return patientList.remove(findById(id));
    }


    @Override
    public Collection<Patient> findPatientByBirthDateBefore(LocalDate localDate) {
        //Collection<Patient> means we need a space to store findings :

        Collection<Patient> patientCollection = new ArrayList<Patient>();
        for (Patient patient : patientList) {
            if (patient.getBirthDate().isBefore(localDate)){
                patientList.add(patient);
        }
    }
        return patientList;
    }
}
