package gov.iti.jets.repository;

import gov.iti.jets.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Inspired By CrudRepository of Spring-Data framework
 */
public interface CrudRepository<T extends BaseEntity> {

    List<T> findAll();

    void deleteById(Integer id);

    void delete(T entity);

    boolean existsById(Integer id);

    long count();

    Optional<T> findById(Integer id);

    void save(T entity);

    void update(T entity);
}
