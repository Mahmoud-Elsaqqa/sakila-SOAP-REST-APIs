package gov.iti.jets.repository;

import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.model.dto.core.FilmModel;
import gov.iti.jets.model.dto.extra.ActorDetailsModel;
import gov.iti.jets.model.dto.extra.FilmDetailsModel;
import gov.iti.jets.model.entity.ActorEntity;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ActorRepositoryImpl implements ActorRepository {


    @Override
    public ActorModel save(ActorModel entity) {
        return null;
    }

    @Override
    public Optional<ActorModel> findById(Integer integer) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        try {
            TypedQuery<ActorEntity> typedQuery = entityManager
                    .createQuery("from actor where actorId=:id", ActorEntity.class);
            typedQuery.setParameter("id", integer);
            ActorEntity entity = typedQuery.getSingleResult();
            return Optional.ofNullable(ActorMapper.INSTANCE.mapToDto(entity));
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            return Optional.empty();
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public List<ActorModel> findAll() {
        return null;
    }

    @Override
    public void delete(ActorModel entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public List<ActorDetailsModel> findAllActorDetailsList() {
        return null;
    }

    @Override
    public Optional<ActorDetailsModel> findActorDetailsById(Integer actorId) {
        return Optional.empty();
    }

    @Override
    public List<FilmModel> findAllActorFilmListById(Integer actorId) {
        return null;
    }

    @Override
    public List<FilmModel> findAllActorFilmListByIdWithFilter(Integer actorId, LocalDate
            releaseYear, FilmRating rating) {
        return null;
    }

    @Override
    public Optional<FilmModel> findActorFilmById(Integer actorId, Integer filmId) {
        return Optional.empty();
    }

    @Override
    public Optional<FilmDetailsModel> findActorFilmDetailsById(Integer actorId, Integer filmId) {
        return Optional.empty();
    }

    @Override
    public Optional<FilmModel> addActorFilm(Integer actorId, Integer filmId) {
        return Optional.empty();
    }

    @Override
    public void removeActorFilm(Integer actorId, Integer filmId) {

    }
}
