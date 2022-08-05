package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Booking {

    private String id;
    private LocalDate dateTime;
    private double price;
    private String administrator;
    private String vaccineType;
    private boolean vacant;
    // for some fields that have relationships it is not meaningfully to be left empty or null
    private Premises premises;
    private Patient patient;

    public Booking(String id, LocalDate dateTime, double price, String administrator,
                   String vaccineType, boolean vacant, Premises premises, Patient patient) {
        setId(id);
        setDate(dateTime);
        setPatient(patient);
        setPremises(premises);
        this.price = price;
        this.administrator = administrator;
        this.vaccineType = vaccineType;
        this.vacant = vacant;
    }

    public String getId() {
        return id;
    }

    public Premises getPremises() {
        return premises;
    }

    public void setPremises(Premises premises) {
        if (premises == null)
            throw new RuntimeException("premise is not allowed to be null");
        this.premises = premises;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setId(String id) {
        if (id == null || id.trim().equals(""))
            throw new RuntimeException("Id must be filled with valid amount");

        this.id = UUID.randomUUID().toString();
    }

    public LocalDate getDate() {
        return dateTime;
    }

    public void setDate(LocalDate date) {
        if (date == null || date.isBefore(LocalDate.now()))
            throw new RuntimeException("the date is not a valid type");
        this.dateTime = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Double.compare(booking.price, price) == 0 && vacant == booking.vacant && Objects.equals(id, booking.id) && Objects.equals(dateTime, booking.dateTime) && Objects.equals(administrator, booking.administrator) && Objects.equals(vaccineType, booking.vaccineType) && Objects.equals(premises, booking.premises) && Objects.equals(patient, booking.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, price, administrator, vaccineType, vacant, premises, patient);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", price=" + price +
                ", administrator='" + administrator + '\'' +
                ", vaccineType='" + vaccineType + '\'' +
                ", vacant=" + vacant +
                ", premises=" + premises +
                ", patient=" + patient +
                '}';
    }
}

