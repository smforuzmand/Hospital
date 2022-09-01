package application;

import dao.ContactInfoDao;
import dao.PatientDao;
import dao.implementations.PatientDaoImpl;
import jdbc.ContactInfoDaoJdbcImpl;
import jdbc.DataBaseCredential;
import model.Booking;
import model.ContactInfo;
import model.Patient;
import model.Premises;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

       DataBaseCredential.Initializer("dataBase/mySQL.properties");

       //if i want to get access to our username and password:
       System.out.println(DataBaseCredential.getInstance().getPassword());

//we are going to run findAll from contactInfoDAOJdbcImpl
        ContactInfoDao infoDao = new ContactInfoDaoJdbcImpl();
        infoDao.findAll().forEach(System.out::println);





    }
}