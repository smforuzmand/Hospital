package dao;

import model.Patient;

import java.time.LocalDate;
import java.util.Collection;

public interface PatientDao extends GenericDaoCRUDOperations<Patient, String> {
    public Patient create(Patient patient);
    Collection<Patient> findAll();
    Patient findById(String id);

    boolean delete(String id);

    Collection<Patient> findPatientByBirthDateBefore(LocalDate localDate);


}
