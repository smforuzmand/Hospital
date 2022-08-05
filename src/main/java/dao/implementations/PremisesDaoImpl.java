package dao.implementations;

import dao.PremisesDao;
import model.Premises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PremisesDaoImpl implements PremisesDao {

    List<Premises> premisesList;

    public PremisesDaoImpl() {
        premisesList = new ArrayList<>();

    }
    @Override
    public Premises create(Premises premises) {
        if (premises == null) throw new RuntimeException("this a null amount");
        premisesList.add(premises);
        return premises;
    }

    @Override
    public Collection<Premises> findAll() {
        return premisesList;
    }

    @Override
    public Premises findById(String id) {
        for (Premises premises : premisesList) {
            if (premises.getId().equals(id)) {
                return premises;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {

        return premisesList.remove(findById(id));
    }

    @Override
    public Collection<Premises> findPremisesByName(String name) {
        Collection<Premises> premisesCollection = new ArrayList<>();
        for (Premises premises : premisesList){
            if (premises.getName().equals(name)) {
                premisesCollection.add(premises);

            }
        }
        return premisesCollection;

    }

    @Override
    public Collection<Premises> findPremisesByAddress(String address) {
        Collection<Premises> premisesCollection = new ArrayList<>();
        for (Premises premises : premisesList){
            if (premises.getAddress().equals(address)) {
                premisesCollection.add(premises);
            }
        }
        return premisesCollection;
    }
}
