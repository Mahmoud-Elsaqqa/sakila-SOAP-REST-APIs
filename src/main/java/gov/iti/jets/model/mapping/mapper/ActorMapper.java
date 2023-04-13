package gov.iti.jets.model.mapping.mapper;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface ActorMapper extends BaseMapper<ActorEntity, ActorModel> {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

//    @Mapping(target = "actorId", ignore = true)
//    @Mapping(target = "fullName.firstName", source = "firstName")
//    @Mapping(target = "fullName.lastName", source = "lastName")
//    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
//    @Mapping(target = "filmActorsByActorId", ignore = true)
//    ActorEntity mapToEntity(ActorRequestModel dto);

    @Mapping(target = "filmActorsByActorId", ignore = true)
    ActorModel mapToDto(ActorEntity entity);
}
