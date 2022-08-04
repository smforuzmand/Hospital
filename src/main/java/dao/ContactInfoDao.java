package dao;

import model.ContactInfo;

import java.util.Collection;

public interface ContactInfoDao {
    ContactInfo create(ContactInfo contactInfo);

    Collection<ContactInfo> findAll();

    ContactInfo findById(String id);

    boolean delete(String id);

    ContactInfo findByEmail(String fEmail);

}
