package gov.iti.jets.soap;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.entity.request.ActorRequestModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ActorWS extends CrudWS<ActorModel, ActorRequestModel> {
    @WebMethod
    public List<ActorModel> getFilmActors(@WebParam(name = "filmId") Integer filmId);
}
