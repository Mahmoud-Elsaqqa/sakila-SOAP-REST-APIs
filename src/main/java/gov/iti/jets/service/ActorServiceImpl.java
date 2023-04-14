package gov.iti.jets.service;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.model.mapping.mapper.ActorMapperImpl;
import gov.iti.jets.repository.ActorRepositoryImpl;
import org.mapstruct.factory.Mappers;

public class ActorServiceImpl extends CrudServiceImpl<ActorModel, ActorEntity, Integer> {
    public ActorServiceImpl() {
        super(new ActorRepositoryImpl(ActorEntity.class), ActorMapper.INSTANCE);
    }
}
