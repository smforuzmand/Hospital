package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
   /* Booking bookingTest = new Booking("123", LocalDate.parse("2022-08-05"),
            2300.5,"Josepe","Covid-19",true,
            new Premises("4212","RonnebyRegion","Kungsgäten",null),null);*/

    @Test
    @DisplayName("Contact information must be a valid field :")
    void setPremisesTest() {
   Booking bookingTest=new Booking();
   bookingTest.setPremises(null);
   Assertions.assertNull(bookingTest.getPremises(),"premise is not allowed to be null");




    }

    @org.junit.jupiter.api.Test
    void setPatient() {
    }

    @org.junit.jupiter.api.Test
    void setId() {
    }

    @org.junit.jupiter.api.Test
    void setDate() {
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
    }

    @org.junit.jupiter.api.Test
    void setAdministrator() {
    }

    @org.junit.jupiter.api.Test
    void setVaccineType() {
    }

    @org.junit.jupiter.api.Test
    void isVacant() {
    }

    @org.junit.jupiter.api.Test
    void setVacant() {
    }
}