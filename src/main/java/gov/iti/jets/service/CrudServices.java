package gov.iti.jets.service;

import gov.iti.jets.model.dto.BaseDto;

import java.util.List;
import java.util.Optional;

public interface CrudServices<T extends BaseDto, ID> {


    List<T> findAll();

    void deleteById(ID id);

    void delete(T dto);

    boolean existsById(ID id);

    long count();

    T findById(ID id);

    void save(T dto);

    void update(T dto);

    void updateById(ID id);
}

