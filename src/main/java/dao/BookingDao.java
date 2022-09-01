package dao;

import model.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public interface BookingDao extends GenericDaoCRUDOperations<Booking , String> {

    Booking findById(String id);

    Collection<Booking> findBookingByDateBetween(LocalDate start, LocalDate end);


    Collection<Booking> findBookingByDateAfter(LocalDate start);


    Collection<Booking> findBookingByDateBefore(LocalDate end);

    Collection<Booking> findBookingByPatientId(String id);

    Collection<Booking> findBookingByPremisesId(String premisesId);

    Collection<Booking> findBookingByVaccineType(String vcType);


}
