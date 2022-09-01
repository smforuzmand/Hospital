package dao;

import model.Premises;

import java.util.Collection;

public interface PremisesDao extends GenericDaoCRUDOperations<Premises, String> {
    Premises findById(String id);

    Collection<Premises> findPremisesByName(String name);

    Collection<Premises> findPremisesByAddress(String address);

}
