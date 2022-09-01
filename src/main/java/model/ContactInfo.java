package model;

import java.util.Objects;

public class ContactInfo {
    private String id;
    private String email;
    private String phone;
    private String address;


    public ContactInfo(String id, String email, String phone, String address) {
        this.id = id;
        setEmail(email);
        setPhone(phone);
        this.address = address;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email==null)
            throw new RuntimeException("not allowed");
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone==null)
            throw new RuntimeException("check phone number");
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone);
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }
}
