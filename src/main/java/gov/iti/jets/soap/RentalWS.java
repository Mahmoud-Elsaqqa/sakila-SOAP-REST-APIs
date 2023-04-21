package gov.iti.jets.soap;

import gov.iti.jets.model.dto.RentalRequestModel;
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
