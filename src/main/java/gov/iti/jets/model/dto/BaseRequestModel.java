package gov.iti.jets.model.dto;


import gov.iti.jets.model.CustomerRequestModel;
import gov.iti.jets.model.entity.request.ActorRequestModel;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.io.Serializable;

@XmlSeeAlso({ActorRequestModel.class, CustomerRequestModel.class, FilmRequestModel.class,
        PaymentRequestModel.class, RentalRequestModel.class, StaffRequestModel.class, StoreRequestModel.class})
public class BaseRequestModel implements Serializable {
}