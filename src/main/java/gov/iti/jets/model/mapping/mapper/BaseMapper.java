package gov.iti.jets.model.mapping.mapper;


import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.BaseRequestModel;
import gov.iti.jets.model.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<E extends BaseEntity, M extends BaseModel, R extends BaseRequestModel> {
    M mapToDto(E entity);

    E mapToEntity(M dto);

    E mapToEntity(R requestDto);

    List<M> mapToDtoList(List<E> entityList);

    List<E> mapToEntityList(List<M> dtoList);
}
