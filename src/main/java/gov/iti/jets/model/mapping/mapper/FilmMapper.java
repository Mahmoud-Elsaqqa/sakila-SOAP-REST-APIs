package gov.iti.jets.model.mapping.mapper;

import gov.iti.jets.model.dto.request.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "default", imports = {LocalDateTime.class})
public interface FilmMapper extends BaseMapper<FilmEntity, FilmModel, FilmRequestModel> {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Mapping(target = "lastUpdate")
    @Mapping(target = "languageByLanguageId", ignore = true)
    @Mapping(target = "languageByOriginalLanguageId", ignore = true)
    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "inventoriesByFilmId", ignore = true)
    FilmModel mapToDto(FilmEntity entity);
}
