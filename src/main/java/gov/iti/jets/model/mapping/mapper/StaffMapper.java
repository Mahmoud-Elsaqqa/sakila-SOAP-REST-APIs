package gov.iti.jets.model.mapping.mapper;


import gov.iti.jets.model.dto.request.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.entity.rental.StaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface StaffMapper extends BaseMapper<StaffEntity, StaffModel, StaffRequestModel> {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Override
    @Mapping(target = "storeByStoreId", ignore = true)
    @Mapping(target = "addressByAddressId", ignore = true)
    @Mapping(target = "paymentsByStaffId", ignore = true)
    @Mapping(target = "storesByStaffId", ignore = true)
    @Mapping(target = "rentalsByStaffId", ignore = true)
    StaffModel mapToDto(StaffEntity entity);
}
