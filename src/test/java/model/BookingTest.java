package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
   /* Booking bookingTest = new Booking("123", LocalDate.parse("2022-08-05"),
            2300.5,"Josepe","Covid-19",true,
            new Premises("4212","RonnebyRegion","Kungsgäten",null),null);*/

    @Test
    @DisplayName("premise is not allowed to be null")
    void setPremises_Null_throws_RuntimeException() {

        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Booking bookingTest = new Booking("123", LocalDate.now().plusDays(2),
                        2300.5, "Josepe", "Covid-19", true, null, null);

            }
        });


    }



}