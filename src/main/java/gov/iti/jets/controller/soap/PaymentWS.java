package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.PaymentRequestModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import jakarta.jws.WebService;

@WebService
public interface PaymentWS extends CrudWS<PaymentModel, PaymentRequestModel> {

}
