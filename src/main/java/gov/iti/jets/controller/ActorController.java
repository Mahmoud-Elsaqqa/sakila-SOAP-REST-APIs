package gov.iti.jets.controller;

import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.model.entity.ActorEntity;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.service.ActorService;
import gov.iti.jets.service.ActorServiceImpl;
import gov.iti.jets.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;


@Path("/actors")
public class ActorController {

        ActorService actorService = new ActorServiceImpl();

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ActorModel getActor(@PathParam("id") String id) {

        /*
        Testing service and dataAccess Layers
        */
        Optional<ActorModel> actor = actorService.getActor(id);
        return actor.get();
    }
}
