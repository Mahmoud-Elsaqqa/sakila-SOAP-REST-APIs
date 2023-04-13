package gov.iti.jets.repository;

import gov.iti.jets.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Inspired By CrudRepository of Spring-Data framework
 */
public interface CrudRepository<T extends BaseEntity, K> {

    List<T> findAll();

    void deleteById(K id);

    void delete(T entity);

    boolean existsById(K id);

    long count();

    Optional<T> findById(K id);

    void save(T entity);

    void update(T entity);
}
