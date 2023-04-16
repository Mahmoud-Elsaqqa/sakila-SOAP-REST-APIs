package gov.iti.jets.repository;


import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.dto.extra.CategorySalesModel;
import gov.iti.jets.model.dto.extra.StoreSalesModel;
import gov.iti.jets.model.entity.rental.PaymentEntity;

import java.util.List;
import java.util.Optional;

public class PaymentRepository extends CrudRepositoryImpl<PaymentEntity, Integer> {
    public PaymentRepository(Class<PaymentEntity> entityClass) {
        super(entityClass);
    }

//    List<PaymentModel> findAllPaymentDetailsList();
//
//    Optional<PaymentModel> findPaymentDetailsById(Integer paymentId);
//
//    List<CategorySalesModel> calculateSalesByCategory();
//
//    List<StoreSalesModel> calculateSalesByStore();
}
