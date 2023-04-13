package gov.iti.jets.repository;


import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.extra.FilmDetailsModel;
import gov.iti.jets.model.entity.inventory.FilmEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class FilmRepository extends CrudRepositoryImpl{
    public FilmRepository() {
        super(FilmEntity.class);
    }
//    List<FilmModel> findAllWithFilter(LocalDate releaseYear, FilmRating rating);
//
//    List<ActorModel> findAllFilmActorListById(Integer filmId);
//
//    Optional<ActorModel> findFilmActorById(Integer filmId, Integer actorId);
//
//    List<FilmDetailsModel> findAllFilmListDetail();
//
//    Optional<FilmDetailsModel> findFilmDetailsById(Integer filmId);
//
//    Optional<FilmModel> findFilmStockById(Integer filmId);
}
