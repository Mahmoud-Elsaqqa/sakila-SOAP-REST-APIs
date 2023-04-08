package gov.iti.jets.controller;

import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.model.entity.ActorEntity;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/actors")
public class ActorController {


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ActorModel getActor(@PathParam("id") Integer id) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        TypedQuery<ActorEntity> query = entityManager.createQuery("from actor where actorId=:id", ActorEntity.class);
        query.setParameter("id", id);
        ActorEntity entity = query.getSingleResult();
        return ActorMapper.INSTANCE.mapToDto(entity);
    }
}
