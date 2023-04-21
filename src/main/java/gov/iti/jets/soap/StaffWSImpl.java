package gov.iti.jets.soap;

import gov.iti.jets.model.dto.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.entity.rental.StaffEntity;
import gov.iti.jets.service.StaffServiceImpl;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "StaffWS", endpointInterface = "gov.iti.jets.soap.StaffWS")
public class StaffWSImpl extends CrudWSImpl<StaffEntity, StaffModel, StaffRequestModel> implements StaffWS {

    private static final StaffServiceImpl service = new StaffServiceImpl();

    //CRUD Endpoints
    public StaffWSImpl() {
        super(service);
    }

    //Custom Endpoints


}
