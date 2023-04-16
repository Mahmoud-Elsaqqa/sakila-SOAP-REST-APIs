package gov.iti.jets.controller;

import gov.iti.jets.model.dto.PaymentRequestModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import gov.iti.jets.service.CrudServiceImpl;
import gov.iti.jets.service.PaymentServiceImpl;
import jakarta.ws.rs.Path;

@Path("/payment")
public class PaymentController extends CrudControllerImpl<PaymentEntity, PaymentModel, PaymentRequestModel>{
    public static final PaymentServiceImpl service = new PaymentServiceImpl();
    public PaymentController() {
        super(service);
    }
}
