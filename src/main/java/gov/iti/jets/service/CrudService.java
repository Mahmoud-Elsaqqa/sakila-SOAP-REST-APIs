package gov.iti.jets.service;

import gov.iti.jets.model.dto.BaseDto;

import java.util.List;

public interface CrudService<T extends BaseDto, K> {

    List<T> findAll();

    void deleteById(K id);

    void delete(T dto);

    boolean existsById(K id);

    long count();

    T findById(K id);

    void save(T dto);

    void update(T dto);

    void updateById(K id);
}

