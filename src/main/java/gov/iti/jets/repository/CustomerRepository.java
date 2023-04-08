package gov.iti.jets.repository;

import gov.iti.jets.model.dto.core.CustomerModel;
import gov.iti.jets.model.dto.core.PaymentModel;
import gov.iti.jets.model.dto.core.RentalModel;
import gov.iti.jets.model.dto.extra.CustomerDetailsModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerModel, Integer>{
    List<CustomerDetailsModel> findAllCustomerDetailsList();

    Optional<CustomerDetailsModel> findCustomerDetailsById(Integer  erId);

    List<PaymentModel> findAllCustomerPaymentListById(Integer  erId);

    List<PaymentModel> findAllCustomerPaymentListByIdWithFilter(Integer  erId, LocalDate startDate, LocalDate endDate);

    List<RentalModel> findAllCustomerRentalListById(Integer  erId);

    List<RentalModel> findAllCustomerRentalListByIdWithFilter(Integer  erId, String status, LocalDate startDate, LocalDate endDate);
}
