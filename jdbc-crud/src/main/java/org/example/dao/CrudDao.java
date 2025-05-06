package org.example.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDao<T extends Serializable, K> {
    void save(T entity);
    T update(T entity);
    Optional<T> findById(K id);
    List<T> findAll();
    void delete(K id);
    void deleteAll();

}
