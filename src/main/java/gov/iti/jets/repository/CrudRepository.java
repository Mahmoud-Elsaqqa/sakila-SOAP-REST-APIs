package gov.iti.jets.repository;

import gov.iti.jets.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Inspired By CrudRepository of Spring-Data framework
 */
public interface CrudRepository<E extends BaseEntity, K> {

    List<E> findAll();

    void deleteById(K id);

    void delete(E entity);

    boolean existsById(K id);

    long count();

    Optional<E> findById(K id);

    void save(E entity);

    void update(K id, E entity);
}
