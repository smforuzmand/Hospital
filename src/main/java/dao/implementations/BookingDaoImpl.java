package dao.implementations;

import dao.BookingDao;
import model.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


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
    public List<Booking> findAll() {
        return bookingList;
    }

    @Override
    public Optional<Booking> findByID(String s) {
        return Optional.empty();
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
    public Collection<Booking> findBookingByDateBetween(LocalDate start, LocalDate end) {

        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getDate().isBefore(end) && booking
                    .getDate().isAfter(start)) {
                bookingCollection.add(booking);
            }
        }

        return bookingCollection;

    }

    @Override
    public Collection<Booking> findBookingByDateAfter(LocalDate start) {

        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getDate().isAfter(start)){
                bookingCollection.add(booking);
            }
        }


        return bookingCollection;
    }

    @Override
    public Collection<Booking> findBookingByDateBefore(LocalDate end) {
        Collection<Booking> bookingCollection = new ArrayList<>();
        for (Booking booking : bookingList){
            if (booking.getDate().isBefore(end)){
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
