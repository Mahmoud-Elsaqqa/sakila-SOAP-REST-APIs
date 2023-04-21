package gov.iti.jets.model.dto;

import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.dto.rental.StaffModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import gov.iti.jets.model.entity.inventory.ActorEntity;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

/**
 * For enforcing generic type
 */
@Getter
@Setter
@XmlSeeAlso({ActorModel.class, CustomerModel.class, FilmModel.class,
        PaymentModel.class, RentalModel.class, StaffModel.class, StoreModel.class})
public abstract class BaseModel {
}
