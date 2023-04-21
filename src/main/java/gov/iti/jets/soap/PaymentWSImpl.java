package gov.iti.jets.soap;

import gov.iti.jets.model.dto.FilmRequestModel;
import gov.iti.jets.model.dto.PaymentRequestModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import gov.iti.jets.service.FilmServiceImpl;
import gov.iti.jets.service.PaymentServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "PaymentWS", endpointInterface = "gov.iti.jets.soap.PaymentWS")
public class PaymentWSImpl extends CrudWSImpl<PaymentEntity, PaymentModel, PaymentRequestModel> implements PaymentWS {

    private static final PaymentServiceImpl service = new PaymentServiceImpl();

    //CRUD Endpoints
    public PaymentWSImpl() {
        super(service);
    }

    //Custom Endpoints


}
