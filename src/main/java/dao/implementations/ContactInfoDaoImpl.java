package dao.implementations;

import dao.ContactInfoDao;
import model.ContactInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ContactInfoDaoImpl implements ContactInfoDao {

    List<ContactInfo> contactInfoList;

    public ContactInfoDaoImpl() {

        contactInfoList = new ArrayList<>();

    }

    @Override
    public ContactInfo create(ContactInfo contactInfo) {
        if (contactInfo == null)
            throw new RuntimeException("null is not allowed");
        contactInfoList.add(contactInfo);
        return contactInfo;
    }


    @Override
    public Collection<ContactInfo> findAll() {
        return contactInfoList;
    }

    @Override
    public Optional<ContactInfo> findByID(String s) {
        return Optional.empty();
    }

    @Override
    public ContactInfo findById(String id) {
        for (ContactInfo info : contactInfoList){
            if (info.getId().equals(id)) {
                return info;
            }
        }

        return null;
    }

    @Override
    public boolean delete(String id) {
        return contactInfoList.remove(findById(id));
    }

    @Override
    public ContactInfo findByEmail(String fEmail) {
        for (ContactInfo info : contactInfoList){
            if (info.getEmail().equals(fEmail)) {
                return info;
            }
        }

        return null;
    }
}
