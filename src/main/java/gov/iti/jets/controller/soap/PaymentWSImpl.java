package gov.iti.jets.controller.soap;

import gov.iti.jets.model.dto.request.PaymentRequestModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import gov.iti.jets.service.PaymentServiceImpl;
import jakarta.jws.WebService;

@WebService(serviceName = "PaymentWS", endpointInterface = "gov.iti.jets.controller.soap.PaymentWS")
public class PaymentWSImpl extends CrudWSImpl<PaymentEntity, PaymentModel, PaymentRequestModel> implements PaymentWS {

    private static final PaymentServiceImpl service = new PaymentServiceImpl();

    //CRUD Endpoints
    public PaymentWSImpl() {
        super(service);
    }

    //Custom Endpoints


}
