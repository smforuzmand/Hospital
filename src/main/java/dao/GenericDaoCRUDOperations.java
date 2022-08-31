package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDaoCRUDOperations<T, ID> {

    public T create(T t);
// A list of whatever we like to store in the future
    List<T> findAll();

    Optional<T> findByID(ID id);

    boolean delete(ID id);





}
