package gov.iti.jets.controller;

import gov.iti.jets.model.dto.core.ActorModel;
import gov.iti.jets.service.ActorService;
import gov.iti.jets.service.ActorServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;


@Path("/actors")
public class ActorController implements CrudController<ActorModel> {

    ActorService actorService = new ActorServiceImpl();

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActorModel getById(@PathParam("id") String id) {
        Optional<ActorModel> actor = actorService.getActor(id);
        return actor.get();
    }

    @Override
    public List<ActorModel> list() {
        return null;
    }

    @Override
    public ActorModel add(ActorModel resource) {
        return null;
    }

    @Override
    public ActorModel update(String id, ActorModel resource) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
