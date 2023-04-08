package gov.iti.jets.service;


import gov.iti.jets.model.dto.core.PaymentModel;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<PaymentModel> getPaymentList();

    Optional<PaymentModel> getPayment(String paymentId);

    List<PaymentModel> getPaymentDetailsList();

    Optional<PaymentModel> getPaymentDetails(String paymentId);

    PaymentModel addPayment(PaymentModel model);

    PaymentModel updatePayment(String paymentId, PaymentModel model);

    void deletePayment(String paymentId);
}
