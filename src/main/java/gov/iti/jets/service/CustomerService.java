package gov.iti.jets.service;


import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.dto.extra.CustomerDetailsModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getCustomerList();

    Optional<CustomerModel> getCustomer(String customerId);

    List<CustomerDetailsModel> getCustomerDetailsList();

    Optional<CustomerDetailsModel> getCustomerDetails(String customerId);

    List<PaymentModel> getCustomerPaymentList(String customerId);

    List<PaymentModel> getCustomerPaymentList(String customerId, String startDate, String endDate);

    List<RentalModel> getCustomerRentalList(String customerId);

    List<RentalModel> getCustomerRentalList(String customerId, String status, String startDate, String endDate);

    CustomerModel addCustomer(CustomerModel model);

    CustomerModel updateCustomer(String customerId, CustomerModel model);

    void deleteCustomer(String customerId);
}
