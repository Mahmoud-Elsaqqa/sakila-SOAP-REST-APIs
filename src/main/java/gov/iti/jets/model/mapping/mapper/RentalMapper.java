package gov.iti.jets.model.mapping.mapper;


import gov.iti.jets.model.dto.RentalRequestModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.entity.rental.RentalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface RentalMapper extends BaseMapper<RentalEntity, RentalModel, RentalRequestModel> {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

//    @Mapping(target = "rentalId", ignore = true)
//    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
//    @Mapping(target = "paymentsByRentalId", ignore = true)
//    @Mapping(target = "inventoryByInventoryId", ignore = true)
//    @Mapping(target = "customerByCustomerId", ignore = true)
//    @Mapping(target = "staffByStaffId", ignore = true)
//    RentalEntity mapToEntity(RentalRequestModel dto);


    @Override
    @Mapping(target = "paymentsByRentalId", ignore = true)
    @Mapping(target = "customerByCustomerId", ignore = true)
    @Mapping(target = "inventoryByInventoryId", ignore = true)
    @Mapping(target = "staffByStaffId", ignore = true)
    RentalModel mapToDto(RentalEntity entity);
}
