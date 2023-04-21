package gov.iti.jets.soap;

import gov.iti.jets.model.dto.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.request.ActorRequestModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface FilmWS extends CrudWS<FilmModel, FilmRequestModel> {
    @WebMethod
    public List<FilmModel> getActorFilms(@WebParam(name = "actorId") Integer actorId);
}
