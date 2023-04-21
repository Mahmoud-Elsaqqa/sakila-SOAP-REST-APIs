package gov.iti.jets.controller.soap;


import gov.iti.jets.model.dto.request.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import jakarta.jws.WebService;

@WebService
public interface StoreWS extends CrudWS<StoreModel, StoreRequestModel> {
}
