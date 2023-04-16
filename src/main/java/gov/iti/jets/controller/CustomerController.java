package gov.iti.jets.controller;

import gov.iti.jets.model.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.service.CrudServiceImpl;
import gov.iti.jets.service.CustomerServiceImpl;
import jakarta.ws.rs.Path;

@Path("/customer")
public class CustomerController extends CrudControllerImpl<CustomerEntity, CustomerModel, CustomerRequestModel> {

    public static final CustomerServiceImpl service = new CustomerServiceImpl();
    public CustomerController() {
        super(service);
    }

}
