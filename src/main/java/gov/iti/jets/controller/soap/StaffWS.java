package gov.iti.jets.controller.soap;


import gov.iti.jets.model.dto.request.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import jakarta.jws.WebService;

@WebService
public interface StaffWS extends CrudWS<StaffModel, StaffRequestModel> {
}
