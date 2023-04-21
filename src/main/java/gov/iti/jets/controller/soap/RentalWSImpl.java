package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.RentalRequestModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.entity.rental.RentalEntity;
import gov.iti.jets.service.RentalServiceImpl;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "RentalWS", endpointInterface = "gov.iti.jets.controller.soap.RentalWS")
public class RentalWSImpl extends CrudWSImpl<RentalEntity, RentalModel, RentalRequestModel> implements RentalWS {

    private static final RentalServiceImpl service = new RentalServiceImpl();

    //CRUD Endpoints
    public RentalWSImpl() {
        super(service);
    }

    @Override
    public List<RentalModel> getRentalsByCustomerId(Integer customerId) {
        return service.getRentalsByCustomerId(customerId);
    }

    //Custom Endpoints


}
