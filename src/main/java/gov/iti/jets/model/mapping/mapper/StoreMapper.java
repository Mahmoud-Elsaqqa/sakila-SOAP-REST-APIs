//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.rental.StoreModel;
//import gov.iti.jets.model.entity.rental.StoreEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface StoreMapper extends GenericMapper<StoreEntity, StoreModel> {
//    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
//
////    @Mapping(target = "storeId", ignore = true)
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "customersByStoreId", ignore = true)
////    @Mapping(target = "inventoriesByStoreId", ignore = true)
////    @Mapping(target = "staffByStoreId", ignore = true)
////    @Mapping(target = "staffByManagerStaffId", ignore = true)
////    @Mapping(target = "addressByAddressId", ignore = true)
////    StoreEntity mapToEntity(StoreRequestModel dto);
//}
