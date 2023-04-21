package gov.iti.jets.soap;

import gov.iti.jets.model.dto.FilmRequestModel;
import gov.iti.jets.model.dto.PaymentRequestModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface PaymentWS extends CrudWS<PaymentModel, PaymentRequestModel> {

}
