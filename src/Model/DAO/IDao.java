package Model.DAO;

import java.util.List;

public interface IDao <T, ID>{

    List<T> findAll();
    T       findById(ID id);

    T       save(T t);
    T       update(T t);
    Boolean delete(T t);
    Boolean deleteById(ID id);
}