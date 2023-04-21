package gov.iti.jets.model.mapping.mapper;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.extra.ActorDetailsModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.dto.request.ActorRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface ActorMapper extends BaseMapper<ActorEntity, ActorModel, ActorRequestModel> {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fullName.firstName", source = "firstName")
    @Mapping(target = "fullName.lastName", source = "lastName")
    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "filmActorsByActorId", ignore = true)
    ActorEntity mapToEntity(ActorRequestModel dto);

    @Mapping(source = "fullName.firstName", target = "firstName")
    @Mapping(source = "fullName.lastName", target = "lastName")
    ActorDetailsModel mapToActorDetails(ActorEntity entity);

    @Mapping(target = "filmActorsByActorId", ignore = true)
    ActorModel mapToDto(ActorEntity entity);
}
