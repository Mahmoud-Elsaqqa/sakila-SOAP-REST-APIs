package gov.iti.jets.service;


import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.response.FilmDetailsModel;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<FilmModel> getFilmList();

    List<FilmModel> getFilmList(String releaseYear, String rating);

    Optional<FilmModel> getFilm(String filmId);

    List<ActorModel> getFilmActorList(String filmId);

    Optional<ActorModel> getFilmActor(String filmId, String actorId);

    List<FilmDetailsModel> getFilmDetailsList();

    Optional<FilmDetailsModel> getFilmDetails(String filmId);

    Optional<FilmModel> getFilmStock(String filmId);

    FilmModel addFilm(FilmModel model);

    FilmModel updateFilm(String filmId, FilmModel model);

    void deleteFilm(String filmId);
}
