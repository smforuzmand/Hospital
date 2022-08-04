package dao;

import model.Booking;

import java.time.LocalDate;
import java.util.Collection;

public interface BookingDao {
    Booking create(Booking booking);

    Collection<Booking> findAll();

    Booking findById(String id);

    boolean delete(String id);

    Collection<Booking> findBookingByDateBetween(LocalDate date1, LocalDate date2);

    Collection<Booking> findBookingByDateAfter(LocalDate localDate);
    Collection<Booking> findBookingByDateBefore(LocalDate localDate);

    Collection<Booking> findBookingByPatientId(String id);

    Collection<Booking> findBookingByPremisesId(String premisesId);

    Collection<Booking> findBookingByVaccineType(String vcType);


}
