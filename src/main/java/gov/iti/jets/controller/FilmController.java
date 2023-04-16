package gov.iti.jets.controller;

import gov.iti.jets.model.dto.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.response.FilmDetailsModel;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.service.FilmServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/film")
public class FilmController extends CrudControllerImpl<FilmEntity, FilmModel, FilmRequestModel> {

    private static final FilmServiceImpl service = new FilmServiceImpl();

    public FilmController() {
        super(service);
    }

    @Path("/actor/{actorId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmModel> getActorFilms(@PathParam("actorId") Integer actorId) {
        return service.findAllFilmsByActorId(actorId);
    }

    @Path("/{filmId}/actors")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorModel> getFilmActors(@PathParam("filmId") Integer filmId) {
        //Dispatching request to ActorController
        return new ActorController().getFilmActors(filmId);
    }

    @Path("/{filmId}/details")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public FilmModel getFilmDetails(@PathParam("filmId") Integer filmId) {
        return service.getFilmDetailsById(filmId);
    }
    @Path("/category/{cat}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmModel> getFilmsByCategory(@PathParam("cat") String cat) {
        return service.getFilmsByCategory(cat.toUpperCase());
    }
}
