package gov.iti.jets.controller;

import gov.iti.jets.model.dto.RentalRequestModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.entity.rental.RentalEntity;
import gov.iti.jets.service.RentalServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rentals")
public class RentalController extends CrudControllerImpl<RentalEntity, RentalModel, RentalRequestModel> {

    public static final RentalServiceImpl service = new RentalServiceImpl();

    public RentalController() {
        super(service);
    }

    @Path("/customer/{customerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalsByCustomerId(@PathParam("customerId") Integer customerId) {
        return Response.ok(
                service.getRentalsByCustomerId(customerId)
        ).build();
    }
}

