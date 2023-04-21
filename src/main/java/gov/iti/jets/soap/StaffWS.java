package gov.iti.jets.soap;


import gov.iti.jets.model.dto.StaffRequestModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface StaffWS extends CrudWS<StaffModel, StaffRequestModel> {
}
