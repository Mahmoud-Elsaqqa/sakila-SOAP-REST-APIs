package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.RentalRequestModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface RentalWS extends CrudWS<RentalModel, RentalRequestModel> {

    @WebMethod
    public List<RentalModel> getRentalsByCustomerId(@WebParam(name = "customerId") Integer customerId);
}
