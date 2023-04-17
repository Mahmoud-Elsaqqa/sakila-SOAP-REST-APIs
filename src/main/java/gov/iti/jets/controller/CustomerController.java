package gov.iti.jets.controller;

import gov.iti.jets.model.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.service.CustomerServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers")
public class CustomerController extends CrudControllerImpl<CustomerEntity, CustomerModel, CustomerRequestModel> {

    public static final CustomerServiceImpl service = new CustomerServiceImpl();

    public CustomerController() {
        super(service);
    }

    //Custom Endpoints
    @Path("{id}/details")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerDetails(@PathParam("id") Integer customerId) {
        return
                Response.ok(service.getCustomerFullDetails(customerId)).build();
    }
    @Path("{id}/rentals/films")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentedFilmsByCustomerId(@PathParam("id") Integer customerId) {
        return
                Response.ok(service.getRentedFilmsByCustomerId(customerId)).build();
    }

}
