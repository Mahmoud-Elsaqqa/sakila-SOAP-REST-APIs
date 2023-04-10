//package gov.iti.jets.model.mapping.mapper;
//
//
//import gov.iti.jets.model.dto.core.FilmModel;
//import gov.iti.jets.model.entity.inventory.FilmEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.time.LocalDateTime;
//
//@Mapper( imports = {LocalDateTime.class})
//public interface FilmMapper extends GenericMapper<FilmEntity, FilmModel> {
//    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
//
////    @Mapping(target = "filmId", ignore = true)
////    @Mapping(target = "lastUpdate", expression = "java(LocalDateTime.now())")
////    @Mapping(target = "languageByLanguageId", ignore = true)
////    @Mapping(target = "languageByOriginalLanguageId", ignore = true)
////    @Mapping(target = "filmActorsByFilmId", ignore = true)
////    @Mapping(target = "filmCategoriesByFilmId", ignore = true)
////    @Mapping(target = "inventoriesByFilmId", ignore = true)
////    FilmEntity mapToEntity(FilmRequestModel dto);
//}
