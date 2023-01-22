package Model.dao;

import java.util.List;

public interface Dao<T> {
    // Read
    T getById(int id);
    List<T>  getAll();

    // Create
    boolean save(T item);
    boolean save(List<T> items);

    // Update
    boolean update(T item);
    boolean update(List<T> items);

    // Delete
    boolean delete(T item);
    boolean delete(List<T> items);
    boolean deleteById(int id);

    

}
