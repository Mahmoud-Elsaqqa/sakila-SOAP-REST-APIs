package gov.iti.jets.service;

import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.model.dto.core.FilmModel;
import gov.iti.jets.model.dto.extra.ActorDetailsModel;
import gov.iti.jets.model.dto.extra.FilmDetailsModel;
import gov.iti.jets.repository.ActorRepository;
import gov.iti.jets.repository.ActorRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ActorServiceImpl implements ActorService {
    ActorRepository actorRepository = new ActorRepositoryImpl();

    @Override
    public List<ActorModel> getActorList() {
        return null;
    }

    @Override
    public Optional<ActorModel> getActor(String actorId) {
        return Optional.of(actorRepository.findById(Integer.valueOf(actorId)))
                .orElseThrow(() -> new IllegalArgumentException("No such"));
    }

    @Override
    public List<ActorDetailsModel> getActorDetailsList() {
        return null;
    }

    @Override
    public Optional<ActorDetailsModel> getActorDetails(String actorId) {
        return Optional.empty();
    }

    @Override
    public List<FilmModel> getActorFilmList(String actorId) {
        return null;
    }

    @Override
    public List<FilmModel> getActorFilmList(String actorId, String releaseYear, String rating) {
        return null;
    }

    @Override
    public Optional<FilmModel> getActorFilm(String actorId, String filmId) {
        return Optional.empty();
    }

    @Override
    public Optional<FilmDetailsModel> getActorFilmDetails(String actorId, String filmId) {
        return Optional.empty();
    }

    @Override
    public List<ActorModel> searchActorList(String name) {
        return null;
    }

    @Override
    public ActorModel addActor(ActorModel model) {
        return null;
    }

    @Override
    public FilmModel addActorFilm(String actorId, String filmId) {
        return null;
    }

    @Override
    public ActorModel updateActor(String actorId, ActorModel model) {
        return null;
    }

    @Override
    public void deleteActor(String actorId) {

    }

    @Override
    public void removeActorFilm(String actorId, String filmId) {

    }
}
