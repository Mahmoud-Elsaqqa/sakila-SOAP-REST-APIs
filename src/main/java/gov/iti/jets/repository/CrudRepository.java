package gov.iti.jets.repository;

import gov.iti.jets.model.entity.BaseEntity;
import java.util.List;
import java.util.Optional;
/**
 * Inspired By CrudRepository of Spring-Data framework
 * */
public interface CrudRepository<T extends BaseEntity, ID> {

    List<T> findAll();

    void deleteById(ID id);

    void delete(T entity);

    boolean existsById(ID id);

    long count();

    Optional<T> findById(ID id);

    void save(T entity);

    void update(T entity);

    void updateById(ID id);
}
