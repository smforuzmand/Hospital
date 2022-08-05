package dao.implementations;

import dao.BookingDao;
import model.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class BookingDaoImpl implements BookingDao {

    List<Booking> bookingList;

    public BookingDaoImpl() {
        bookingList = new ArrayList<>();
    }


    @Override
    public Booking create(Booking booking) {

        if (booking == null) throw new RuntimeException("Null is not allowed");
        bookingList.add(booking);
        return booking;
    }

    @Override
    public Collection<Booking> findAll() {
        return bookingList;
    }

    @Override
    public Booking findById(String id) {
        for (Booking booking : bookingList) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {

        return bookingList.remove(findById(id));
    }

    @Override
    public Collection<Booking> findBookingByDateBetween(LocalDate date1, LocalDate date2) {

        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getDate().isBefore(date2) && booking
                    .getDate().isAfter(date1)) {
                bookingCollection.add(booking);
            }
        }

        return bookingCollection;

    }

    @Override
    public Collection<Booking> findBookingByDateAfter(LocalDate localDate) {

        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getDate().isAfter(localDate)){
                bookingCollection.add(booking);
            }
        }


        return bookingCollection;
    }

    @Override
    public Collection<Booking> findBookingByDateBefore(LocalDate localDate) {
        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getDate().isBefore(localDate)){
                bookingCollection.add(booking);
            }
        }

        return bookingCollection;
    }

    @Override
    public Collection<Booking> findBookingByPatientId(String id) {
        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getPatient().equals(id)){
                bookingCollection.add(booking);
            }
        }

        return bookingCollection;

     }

    @Override
    public Collection<Booking> findBookingByPremisesId(String premisesId) {
        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getPremises().equals(premisesId)){
                bookingCollection.add(booking);
            }
        }

        return bookingCollection;


    }

    @Override
    public Collection<Booking> findBookingByVaccineType(String vcType) {
        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getVaccineType().equals(vcType)){
                bookingCollection.add(booking);
            }
        }

        return bookingCollection;

    }
}
