package gov.iti.jets.service;

import gov.iti.jets.model.dto.request.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.extra.CustomerDetailsModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.model.mapping.mapper.CustomerMapper;
import gov.iti.jets.model.mapping.mapper.FilmMapper;
import gov.iti.jets.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl extends CrudServiceImpl<CustomerEntity, CustomerModel, CustomerRequestModel, Integer> {
    public static final CustomerRepository repository = new CustomerRepository(CustomerEntity.class);
    public static final CustomerMapper mapper = CustomerMapper.INSTANCE;

    public CustomerServiceImpl() {
        super(repository, mapper);
    }

    public CustomerDetailsModel getCustomerFullDetails(Integer customerId) {
        return
                repository.getCustomerFullDetails(customerId);
    }

    public List<FilmModel> getRentedFilmsByCustomerId(Integer customerId) {
        return
                FilmMapper.INSTANCE.mapToDtoList(repository.getRentedFilmsByCustomerId(customerId));
    }
}
