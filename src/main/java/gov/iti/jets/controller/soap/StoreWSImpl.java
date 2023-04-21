package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.entity.rental.StoreEntity;
import gov.iti.jets.service.StoreServiceImpl;
import jakarta.jws.WebService;

@WebService(serviceName = "StoreWS", endpointInterface = "gov.iti.jets.controller.soap.StoreWS")
public class StoreWSImpl extends CrudWSImpl<StoreEntity, StoreModel, StoreRequestModel> implements StoreWS {

    private static final StoreServiceImpl service = new StoreServiceImpl();

    //CRUD Endpoints
    public StoreWSImpl() {
        super(service);
    }

    //Custom Endpoints


}
