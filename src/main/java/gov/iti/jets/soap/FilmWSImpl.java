package gov.iti.jets.soap;

import gov.iti.jets.model.dto.FilmRequestModel;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.model.entity.request.ActorRequestModel;
import gov.iti.jets.service.ActorServiceImpl;
import gov.iti.jets.service.FilmService;
import gov.iti.jets.service.FilmServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "ActorWS", endpointInterface = "gov.iti.jets.soap.FilmWS")
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
