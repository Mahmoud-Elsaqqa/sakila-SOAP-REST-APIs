package gov.iti.jets.repository;

import gov.iti.jets.model.dto.extra.ActorDetailsModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.util.EntityManagerHelper;

import java.util.List;

public class ActorRepository extends CrudRepositoryImpl<ActorEntity, Integer> {

    public ActorRepository(Class<ActorEntity> entityClass) {
        super(entityClass);
    }

    public ActorDetailsModel getActorDetails(Integer actorId) {
        ActorDetailsModel actorDetailsModel = EntityManagerHelper.getEntityManager()
                .createQuery("SELECT NEW gov.iti.jets.model.dto.request.ActorDetailsModel (a.id, a.fullName.firstName, a.fullName.lastName) " +
                        "FROM actor a WHERE a.id = :id", ActorDetailsModel.class)
                .setParameter("id", actorId)
                .getSingleResult();
        return actorDetailsModel;
    }

    public List<ActorEntity> findAllActorsByFilmId(Integer filmId) {
        return
                EntityManagerHelper.getEntityManager()
                        .createQuery("SELECT actorByActorId FROM film_actor where filmId = :id", ActorEntity.class)
                        .setParameter("id", filmId)
                        .getResultList();
    }
}
