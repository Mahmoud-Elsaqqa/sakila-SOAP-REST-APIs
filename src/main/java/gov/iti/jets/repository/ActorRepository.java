package gov.iti.jets.repository;


import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.model.dto.core.FilmModel;
import gov.iti.jets.model.dto.extra.ActorDetailsModel;
import gov.iti.jets.model.dto.extra.FilmDetailsModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActorRepository extends CrudRepository<ActorModel, Integer> {
    List<ActorDetailsModel> findAllActorDetailsList();

    Optional<ActorDetailsModel> findActorDetailsById(Integer actorId);

    List<FilmModel> findAllActorFilmListById(Integer actorId);

    List<FilmModel> findAllActorFilmListByIdWithFilter(Integer actorId, LocalDate releaseYear, FilmRating rating);

    Optional<FilmModel> findActorFilmById(Integer actorId, Integer filmId);

    Optional<FilmDetailsModel> findActorFilmDetailsById(Integer actorId, Integer filmId);

    Optional<FilmModel> addActorFilm(Integer actorId, Integer filmId);

    void removeActorFilm(Integer actorId, Integer filmId);
}
