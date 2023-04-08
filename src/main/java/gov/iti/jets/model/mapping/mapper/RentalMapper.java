//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.core.RentalModel;
//import gov.iti.jets.model.entity.RentalEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface RentalMapper extends GenericMapper<RentalEntity, RentalModel> {
//    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);
//
////    @Mapping(target = "rentalId", ignore = true)
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "paymentsByRentalId", ignore = true)
////    @Mapping(target = "inventoryByInventoryId", ignore = true)
////    @Mapping(target = "customerByCustomerId", ignore = true)
////    @Mapping(target = "staffByStaffId", ignore = true)
////    RentalEntity mapToEntity(RentalRequestModel dto);
//}
