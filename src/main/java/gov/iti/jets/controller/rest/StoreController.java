package gov.iti.jets.controller.rest;

import gov.iti.jets.model.dto.request.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.entity.rental.StoreEntity;
import gov.iti.jets.service.StoreServiceImpl;
import jakarta.ws.rs.Path;

@Path("/store")
public class StoreController extends CrudControllerImpl<StoreEntity, StoreModel, StoreRequestModel> {
    public static final StoreServiceImpl service = new StoreServiceImpl();

    public StoreController() {
        super(service);
    }
}
