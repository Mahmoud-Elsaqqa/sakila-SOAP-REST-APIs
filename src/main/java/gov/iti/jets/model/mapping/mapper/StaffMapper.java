//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.core.StaffModel;
//import gov.iti.jets.model.entity.rental.StaffEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface StaffMapper extends GenericMapper<StaffEntity, StaffModel> {
//    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
//
////    @Mapping(target = "staffId", ignore = true)
////    @Mapping(target = "fullName.firstName", source = "firstName")
////    @Mapping(target = "fullName.lastName", source = "lastName")
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "paymentsByStaffId", ignore = true)
////    @Mapping(target = "rentalsByStaffId", ignore = true)
////    @Mapping(target = "addressByAddressId", ignore = true)
////    @Mapping(target = "storeByStoreId", ignore = true)
////    @Mapping(target = "storesByStaffId", ignore = true)
////    StaffEntity mapToEntity(StaffRequestModel dto);
//}
