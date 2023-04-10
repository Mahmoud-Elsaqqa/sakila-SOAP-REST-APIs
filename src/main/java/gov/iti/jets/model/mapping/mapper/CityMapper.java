//package gov.iti.jets.model.mapping.mapper;
//
//import gov.iti.jets.model.dto.customer.CityModel;
//import gov.iti.jets.model.entity.customer.CityEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface CityMapper extends GenericMapper<CityEntity, CityModel> {
//    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
////
////    @Mapping(target = "cityId", ignore = true)
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "addressesByCityId", ignore = true)
////    @Mapping(target = "countryByCountryId", ignore = true)
////    CityEntity mapToEntity(CityRequestModel dto);
//}
