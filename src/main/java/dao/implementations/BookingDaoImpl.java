package dao.implementations;

import dao.BookingDao;
import model.Booking;

import java.time.LocalDate;
import java.util.Collection;

public class BookingDaoImpl implements BookingDao {
    @Override
    public Booking create(Booking booking) {
        return null;
    }

    @Override
    public Collection<Booking> findAll() {
        return null;
    }

    @Override
    public Booking findById(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Collection<Booking> findBookingByDateBetween(LocalDate date1, LocalDate date2) {
        return null;
    }

    @Override
    public Collection<Booking> findBookingByDateAfter(LocalDate localDate) {
        return null;
    }

    @Override
    public Collection<Booking> findBookingByDateBefore(LocalDate localDate) {
        return null;
    }

    @Override
    public Collection<Booking> findBookingByPatientId(String id) {
        return null;
    }

    @Override
    public Collection<Booking> findBookingByPremisesId(String premisesId) {
        return null;
    }

    @Override
    public Collection<Booking> findBookingByVaccineType(String vcType) {
        return null;
    }
}
