package gov.iti.jets.repository;


import gov.iti.jets.model.entity.rental.PaymentEntity;

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
