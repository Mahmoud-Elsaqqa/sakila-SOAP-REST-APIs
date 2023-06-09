package gov.iti.jets.controller.rest;

import gov.iti.jets.model.dto.request.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.entity.rental.StaffEntity;
import gov.iti.jets.service.StaffServiceImpl;
import jakarta.ws.rs.Path;

@Path("/staff")
public class StaffController extends CrudControllerImpl<StaffEntity, StaffModel, StaffRequestModel> {

    public static final StaffServiceImpl service = new StaffServiceImpl();

    public StaffController() {
        super(service);
    }
}
