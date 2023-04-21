package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import gov.iti.jets.model.dto.request.ActorRequestModel;
import gov.iti.jets.service.ActorServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "ActorWS", endpointInterface = "gov.iti.jets.controller.soap.ActorWS")
public class ActorWSImpl extends CrudWSImpl<ActorEntity, ActorModel, ActorRequestModel> implements ActorWS{

    private static final ActorServiceImpl service = new ActorServiceImpl();

    //CRUD Endpoints
    public ActorWSImpl() {
        super(service);
    }

    //Custom Endpoints

    @Override
    @WebMethod
    public List<ActorModel> getFilmActors(@WebParam(name = "filmId") Integer filmId) {
        return service.findAllActorsByFilmId(filmId);
    }
}
