package gov.iti.jets.model.dto.customer;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.FullName;
import gov.iti.jets.model.dto.rental.PaymentModel;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.dto.rental.StoreModel;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@XmlRootElement
@AllArgsConstructor
public class CustomerModel extends BaseModel {
    private Integer id;

    private Integer storeId;

    private FullName fullName;

    @Size(min = 1, max = 50)
    private String email;

    private Integer addressId;

    private Boolean active;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
//    @JsonbTransient
    private StoreModel storeByStoreId;

    @ToString.Exclude
//    @JsonbTransient
    private AddressModel addressByAddressId;

    @ToString.Exclude
    @JsonbTransient
    private Collection<PaymentModel> paymentsByCustomerId;

    @ToString.Exclude
    @JsonbTransient
    private Collection<RentalModel> rentalsByCustomerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(storeId, that.storeId)
                && Objects.equal(fullName, that.fullName)
                && Objects.equal(email, that.email)
                && Objects.equal(addressId, that.addressId)
                && Objects.equal(active, that.active)
                && Objects.equal(createDate, that.createDate)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, storeId, fullName, email,
                addressId, active, createDate, lastUpdate);
    }
}
