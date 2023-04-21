package gov.iti.jets.service;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.extra.ActorDetailsModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.model.dto.request.ActorRequestModel;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.model.mapping.mapper.FilmMapper;
import gov.iti.jets.repository.ActorRepository;
import gov.iti.jets.repository.FilmRepository;

import java.util.List;

public class ActorServiceImpl extends CrudServiceImpl<ActorEntity, ActorModel, ActorRequestModel, Integer> {

    private static final ActorRepository repository = new ActorRepository(ActorEntity.class);
    private static final FilmRepository filmRepository = new FilmRepository(FilmEntity.class);
    private static final ActorMapper mapper = ActorMapper.INSTANCE;

    public ActorServiceImpl() {
        super(repository, mapper);
    }

    public List<ActorModel> findAllActorsByFilmId(Integer filmId) {
        return
                mapper.mapToDtoList(repository.findAllActorsByFilmId(filmId));
    }

    public ActorDetailsModel getActorDetailsById(Integer id) {
        ActorDetailsModel actorDetails = repository.getActorDetails(id);
        actorDetails.setFilmInfo(
                FilmMapper.INSTANCE.mapToDtoList(
                        filmRepository.findAllFilmsByActorId(id))
        );
        return actorDetails;
    }
}
