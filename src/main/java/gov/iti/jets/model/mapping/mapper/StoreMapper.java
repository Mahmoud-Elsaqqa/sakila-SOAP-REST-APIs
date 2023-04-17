package gov.iti.jets.model.mapping.mapper;


import gov.iti.jets.model.dto.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.entity.rental.StoreEntity;
import org.hibernate.query.sqm.produce.function.StandardArgumentsValidators;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface StoreMapper extends BaseMapper<StoreEntity, StoreModel, StoreRequestModel> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
//    @Mapping(target = "customersByStoreId", ignore = true)
//    @Mapping(target = "inventoriesByStoreId", ignore = true)
//    @Mapping(target = "staffByStoreId", ignore = true)
//    @Mapping(target = "staffByManagerStaffId", ignore = true)
//    @Mapping(target = "addressByAddressId", ignore = true)
//    StoreEntity mapToEntity(StoreRequestModel dto);


    @Override
    @Mapping(target = "addressByAddressId", ignore = true)
    @Mapping(target = "customersByStoreId", ignore = true)
    @Mapping(target = "inventoriesByStoreId", ignore = true)
    @Mapping(target = "staffByManagerStaffId", ignore = true)
    @Mapping(target = "staffByStoreId", ignore = true)
    StoreModel mapToDto(StoreEntity entity);
}
