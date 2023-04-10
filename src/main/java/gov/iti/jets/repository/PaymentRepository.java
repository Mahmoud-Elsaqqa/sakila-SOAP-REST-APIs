package gov.iti.jets.repository;


import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.dto.extra.CategorySalesModel;
import gov.iti.jets.model.dto.extra.StoreSalesModel;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    List<PaymentModel> findAllPaymentDetailsList();

    Optional<PaymentModel> findPaymentDetailsById(Integer paymentId);

    List<CategorySalesModel> calculateSalesByCategory();

    List<StoreSalesModel> calculateSalesByStore();
}
