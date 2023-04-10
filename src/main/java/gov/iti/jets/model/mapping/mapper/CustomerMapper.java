//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.customer.CustomerModel;
//import gov.iti.jets.model.entity.customer.CustomerEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface CustomerMapper extends GenericMapper<CustomerEntity, CustomerModel> {
//    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
////
////    @Mapping(target = "customerId", ignore = true)
////    @Mapping(target = "fullName.firstName", source = "firstName")
////    @Mapping(target = "fullName.lastName", source = "lastName")
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "storeByStoreId", ignore = true)
////    @Mapping(target = "addressByAddressId", ignore = true)
////    @Mapping(target = "paymentsByCustomerId", ignore = true)
////    @Mapping(target = "rentalsByCustomerId", ignore = true)
////    CustomerEntity mapToEntity(CustomerRequestModel dto);
//}
