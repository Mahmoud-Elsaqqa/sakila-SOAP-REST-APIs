package gov.iti.jets.service;

import gov.iti.jets.model.CustomerRequestModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.model.mapping.mapper.BaseMapper;
import gov.iti.jets.model.mapping.mapper.CustomerMapper;
import gov.iti.jets.repository.CrudRepository;
import gov.iti.jets.repository.CustomerRepository;

public class CustomerServiceImpl extends CrudServiceImpl<CustomerEntity, CustomerModel, CustomerRequestModel,Integer> {
    public static final CustomerRepository repository = new CustomerRepository(CustomerEntity.class);
    public static final CustomerMapper mapper = CustomerMapper.INSTANCE;

    public CustomerServiceImpl() {
        super(repository, mapper);
    }
}
