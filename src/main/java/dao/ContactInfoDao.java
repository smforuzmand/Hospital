package dao;

import model.ContactInfo;

import java.util.Optional;

public interface ContactInfoDao extends GenericDaoCRUDOperations<ContactInfo ,String> {
    Optional<ContactInfo> findById(String id);

    // the type of object is contactInfo and there the type of the Id is the string
   /* ContactInfo create(ContactInfo contactInfo);

    Collection<ContactInfo> findAll();

    ContactInfo findById(String id);

    boolean delete(String id);

    ContactInfo findByEmail(String fEmail);
*/
    Optional<ContactInfo> findByEmail(String email);


}