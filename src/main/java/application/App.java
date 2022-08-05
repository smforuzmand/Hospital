package application;

import dao.PatientDao;
import dao.implementations.PatientDaoImpl;
import model.Booking;
import model.ContactInfo;
import model.Patient;
import model.Premises;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Patient patient1 = new Patient(
                "19990909-9999", "Adam", "Johanson",
                LocalDate.parse("1999-09-09"), new ContactInfo("1", "AdamJ@email.com",
                "07000000"));
        PatientDao patientDao1 = new PatientDaoImpl();
        patientDao1.create(patient1);
        patientDao1.create(new Patient("111", "12552-4444", "Julian", null,
                "Asanj", LocalDate.parse("1986-04-11")));
        int size = patientDao1.findAll().size();
        System.out.println(size);
        System.out.println(patientDao1.findById("111"));
        Booking bookingTest = new Booking("123", LocalDate.parse("2022-08-05"),
                2300.5,"Josepe","Covid-19",true,null,null);






    }
}