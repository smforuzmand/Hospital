package dao;

import model.Patient;

import java.time.LocalDate;
import java.util.Collection;

public interface PatientDao extends GenericDaoCRUDOperations<Patient, String> {
    Patient findById(String id);

    Collection<Patient> findPatientByBirthDateBefore(LocalDate localDate);


}
