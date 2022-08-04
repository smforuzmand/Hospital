package model;

import java.util.Objects;
import java.util.UUID;

public class Premises {
    private String id;
    private String name;
    private String address;
    public ContactInfo contactInfo;


    public Premises(String id, String name, String address, ContactInfo contactInfo) {
        this.id = UUID.randomUUID().toString();
        setContactInfo(contactInfo);
        setName(name);
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        if (contactInfo == null)
            throw new RuntimeException("Contact information must be a valid field :");
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals(""))
            throw new RuntimeException("Name must be a valid field ");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premises premises = (Premises) o;
        return Objects.equals(id, premises.id) && Objects.equals(name, premises.name) && Objects.equals(address, premises.address) && Objects.equals(contactInfo, premises.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, contactInfo);
    }


}
