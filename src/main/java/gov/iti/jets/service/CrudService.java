package gov.iti.jets.service;

import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import gov.iti.jets.model.entity.BaseEntity;

import java.util.List;

public interface CrudService<E extends BaseEntity, M extends BaseModel, R extends BaseRequestModel, K> {

    List<M> findAll();

    void deleteById(K id);

    boolean existsById(K id);

    long count();

    M findById(K id);

    void save(R dto);

    void update(K id, R dto);

}

