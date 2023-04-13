package gov.iti.jets.model.mapping.mapper;

import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<T extends BaseEntity, U extends BaseDto> {
    U mapToDto(T entity);

    T mapToEntity(U dto);

    List<U> mapToDtoList(List<T> entityList);

    List<T> mapToEntityList(List<U> dtoList);
}
