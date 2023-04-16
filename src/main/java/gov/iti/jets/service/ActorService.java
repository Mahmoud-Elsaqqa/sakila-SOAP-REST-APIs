package gov.iti.jets.service;


import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.response.ActorDetailsModel;
import gov.iti.jets.model.dto.response.FilmDetailsModel;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    List<ActorModel> getActorList();

    Optional<ActorModel> getActor(String actorId);

    List<ActorDetailsModel> getActorDetailsList();

    Optional<ActorDetailsModel> getActorDetails(String actorId);

    List<FilmModel> getActorFilmList(String actorId);

    List<FilmModel> getActorFilmList(String actorId, String releaseYear, String rating);

    Optional<FilmModel> getActorFilm(String actorId, String filmId);

    Optional<FilmDetailsModel> getActorFilmDetails(String actorId, String filmId);

    List<ActorModel> searchActorList(String name);

    ActorModel addActor(ActorModel model);

    FilmModel addActorFilm(String actorId, String filmId);

    ActorModel updateActor(String actorId, ActorModel model);

    void deleteActor(String actorId);

    void removeActorFilm(String actorId, String filmId);
}
