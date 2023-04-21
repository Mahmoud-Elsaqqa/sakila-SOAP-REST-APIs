package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.service.FilmServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "ActorWS", endpointInterface = "gov.iti.jets.controller.soap.FilmWS")
public class FilmWSImpl extends CrudWSImpl<FilmEntity, FilmModel, FilmRequestModel> implements FilmWS {

    private static final FilmServiceImpl service = new FilmServiceImpl();

    //CRUD Endpoints
    public FilmWSImpl() {
        super(service);
    }

    //Custom Endpoints
    @WebMethod
    public List<FilmModel> getActorFilms(@WebParam(name = "actorId") Integer actorId) {
        return service.findAllFilmsByActorId(actorId);
    }

}
