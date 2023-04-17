package gov.iti.jets.controller;

import gov.iti.jets.model.dto.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.entity.rental.StoreEntity;
import gov.iti.jets.service.CrudServiceImpl;
import gov.iti.jets.service.StoreServiceImpl;

public class StoreController extends CrudControllerImpl<StoreEntity, StoreModel, StoreRequestModel> {
    public static final StoreServiceImpl service = new StoreServiceImpl();
    public StoreController() {
        super(service);
    }
}
