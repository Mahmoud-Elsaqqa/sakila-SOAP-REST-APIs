package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.entity.rental.StaffEntity;
import gov.iti.jets.service.StaffServiceImpl;
import jakarta.jws.WebService;

@WebService(serviceName = "StaffWS", endpointInterface = "gov.iti.jets.controller.soap.StaffWS")
public class StaffWSImpl extends CrudWSImpl<StaffEntity, StaffModel, StaffRequestModel> implements StaffWS {

    private static final StaffServiceImpl service = new StaffServiceImpl();

    //CRUD Endpoints
    public StaffWSImpl() {
        super(service);
    }

    //Custom Endpoints


}
