package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.extra.CustomerDetailsModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.service.CustomerServiceImpl;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "CustomerWS", endpointInterface = "gov.iti.jets.controller.soap.CustomerWS")
public class CustomerWSImpl extends CrudWSImpl<CustomerEntity, CustomerModel, CustomerRequestModel> implements CustomerWS {

    private static final CustomerServiceImpl service = new CustomerServiceImpl();

    //CRUD Endpoints
    public CustomerWSImpl() {
        super(service);
    }


    //Custom Endpoints
    @Override
    public CustomerDetailsModel getCustomerDetails(Integer customerId) {
        return service.getCustomerFullDetails(customerId);
    }

    @Override
    public List<FilmModel> getRentedFilmsByCustomerId(Integer customerId) {
        return service.getRentedFilmsByCustomerId(customerId);
    }

}
