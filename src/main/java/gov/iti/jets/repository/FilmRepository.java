package gov.iti.jets.repository;


import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.model.dto.core.FilmModel;
import gov.iti.jets.model.dto.extra.FilmDetailsModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends CrudRepository<FilmModel, Integer> {
    List<FilmModel> findAllWithFilter(LocalDate releaseYear, FilmRating rating);

    List<ActorModel> findAllFilmActorListById(Integer filmId);

    Optional<ActorModel> findFilmActorById(Integer filmId, Integer actorId);

    List<FilmDetailsModel> findAllFilmListDetail();

    Optional<FilmDetailsModel> findFilmDetailsById(Integer filmId);

    Optional<FilmModel> findFilmStockById(Integer filmId);
}
