package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.extra.CustomerDetailsModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CustomerWS extends CrudWS<CustomerModel, CustomerRequestModel> {

    //Custom Endpoints
    @WebMethod
    public CustomerDetailsModel getCustomerDetails(@WebParam(name = "customerId") Integer customerId);

    @WebMethod
    public List<FilmModel> getRentedFilmsByCustomerId(@WebParam(name = "customerId") Integer customerId);


}
