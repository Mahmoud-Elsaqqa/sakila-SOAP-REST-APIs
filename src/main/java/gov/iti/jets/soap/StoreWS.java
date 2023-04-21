package gov.iti.jets.soap;


import gov.iti.jets.model.dto.StoreRequestModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import jakarta.jws.WebService;

@WebService
public interface StoreWS extends CrudWS<StoreModel, StoreRequestModel> {
}
