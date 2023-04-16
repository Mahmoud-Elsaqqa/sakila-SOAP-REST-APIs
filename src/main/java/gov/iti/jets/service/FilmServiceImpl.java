package gov.iti.jets.service;

import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.dto.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.response.ActorDetailsModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.model.mapping.mapper.FilmMapper;
import gov.iti.jets.repository.ActorRepository;
import gov.iti.jets.repository.FilmRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

public class FilmServiceImpl extends CrudServiceImpl<FilmEntity, FilmModel, FilmRequestModel, Integer> {
    private static final FilmRepository filmRepository = new FilmRepository(FilmEntity.class);
    private static final ActorRepository actorRepository = new ActorRepository(ActorEntity.class);
    //    private static final FilmMapper mapper = FilmMapper.INSTANCE;
    private static final FilmMapper mapper = Mappers.getMapper(FilmMapper.class);

    public FilmServiceImpl() {
        super(filmRepository, mapper);
    }

    public List<FilmModel> findAllFilmsByActorId(Integer actorId) {
        return
                mapper.mapToDtoList(filmRepository.findAllFilmsByActorId(actorId));
    }

    public FilmModel getFilmDetailsById(Integer filmId) {
        List<ActorDetailsModel> actorModels =
                actorRepository.findAllActorsByFilmId(filmId).stream()
                        .map(actorEntity -> ActorMapper.INSTANCE.mapToActorDetails(actorEntity))
                        .collect(Collectors.toList());
        FilmModel filmDetails = super.findById(filmId);
        filmDetails.setActors(actorModels);
        return filmDetails;
    }

    public List<FilmModel> getFilmsByCategory(String cat) {
        return
                mapper.mapToDtoList(filmRepository.getFilmsByCategory(Category.valueOf(cat)));
    }
}
