//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.customer.AddressModel;
//import gov.iti.jets.model.entity.customer.AddressEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface AddressMapper extends GenericMapper<AddressEntity, AddressModel> {
//    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
//
////    @Mapping(target = "addressId", ignore = true)
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "cityByCityId", ignore = true)
////    @Mapping(target = "customersByAddressId", ignore = true)
////    @Mapping(target = "staffByAddressId", ignore = true)
////    @Mapping(target = "storesByAddressId", ignore = true)
////    AddressEntity mapToEntity(AddressRequestModel dto);
//}
