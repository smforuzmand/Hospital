package dao;

import model.Premises;

import java.util.Collection;

public interface PremisesDao {
    Premises create(Premises premises);

    Collection<Premises> findAll();

    Premises findById(String id);

    boolean delete(String id);

    Collection<Premises> findPremisesByName(String name);

    Collection<Premises> findPremisesByAddress(String address);

}
