package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface FilmWS extends CrudWS<FilmModel, FilmRequestModel> {
    @WebMethod
    public List<FilmModel> getActorFilms(@WebParam(name = "actorId") Integer actorId);
}
