package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Patient {

    private String id;
    private String ssn;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public ContactInfo contactInfo;


    public Patient(String id, String ssn, String firstName, ContactInfo contactInfo, String lastName, LocalDate birthDate) {
        this.id = id;
        setSsn(ssn);// when we have conditioned a setter , we can replace this. statement with
        // calling that method directly in the constructor!
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.contactInfo = contactInfo;
    }

    //UUID is used instead of this.id to generate random id
    public Patient(String ssn, String firstName, String lastName, LocalDate birthDate, ContactInfo contactInfo) {
        this(UUID.randomUUID().toString(), ssn, firstName, contactInfo, lastName, birthDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if ((ssn == null) || (ssn.trim().equals("")))//to avoid having ssn an invalid number or empty space
            throw new RuntimeException("Social Security Number must be valid ");
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //We're going to make a connection to the ContactInfo class
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(ssn, patient.ssn) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(birthDate, patient.birthDate) && Objects.equals(contactInfo, patient.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ssn, firstName, lastName, birthDate, contactInfo);
    }

    @Override
    // we decide to ignore disclosing the ssn in public
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
