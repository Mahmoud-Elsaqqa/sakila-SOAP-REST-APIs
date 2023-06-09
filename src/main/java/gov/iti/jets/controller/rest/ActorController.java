package gov.iti.jets.controller.rest;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.dto.request.ActorRequestModel;
import gov.iti.jets.service.ActorServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/actors")
public class ActorController extends CrudControllerImpl<ActorEntity, ActorModel, ActorRequestModel> {

    private static final ActorServiceImpl service = new ActorServiceImpl();

    //CRUD Endpoints
    public ActorController() {
        super(service);
    }

    //Custom Endpoints
    @Path("{actorId}/films")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmModel> getActorFilms(@PathParam("actorId") Integer id) {
        //Request Dispatch to Films Controller == /films/{actorId}
        return new FilmController().getActorFilms(id);
    }

    @Path("/film/{filmId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorModel> getFilmActors(@PathParam("filmId") Integer filmId) {
        return service.findAllActorsByFilmId(filmId);
    }

    @Path("/{id}/details")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorDetails(@PathParam("id") Integer id) {
        Object o = service.getActorDetailsById(id);
        return Response.ok(o).build();
    }
}


