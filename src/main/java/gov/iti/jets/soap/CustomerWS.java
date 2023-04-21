package gov.iti.jets.soap;

import gov.iti.jets.controller.RentalController;
import gov.iti.jets.model.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.extra.CustomerDetailsModel;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public interface CustomerWS extends CrudWS<CustomerModel, CustomerRequestModel> {

    //Custom Endpoints
    @WebMethod
    public CustomerDetailsModel getCustomerDetails(@WebParam(name = "customerId") Integer customerId);

    @WebMethod
    public List<FilmModel> getRentedFilmsByCustomerId(@WebParam(name = "customerId") Integer customerId);


}
