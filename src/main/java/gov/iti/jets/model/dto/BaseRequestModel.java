package gov.iti.jets.model.dto;


import gov.iti.jets.model.dto.request.CustomerRequestModel;
import gov.iti.jets.model.dto.request.*;
import gov.iti.jets.model.dto.request.ActorRequestModel;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.io.Serializable;

@XmlSeeAlso({ActorRequestModel.class, CustomerRequestModel.class, FilmRequestModel.class,
        PaymentRequestModel.class, RentalRequestModel.class, StaffRequestModel.class, StoreRequestModel.class})
public class BaseRequestModel implements Serializable {
}