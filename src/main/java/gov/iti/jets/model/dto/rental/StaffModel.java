package gov.iti.jets.model.dto.rental;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.FullName;
import gov.iti.jets.model.dto.customer.AddressModel;
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
public class StaffModel extends BaseModel {
    private Integer id;

    private FullName fullName;

    private Integer addressId;


    // private byte[] picture;

    @Size(min = 1, max = 50)
    private String email;

    private Integer storeId;

    private Boolean active;

    @Size(min = 1, max = 16)
    private String username;

    @Size(min = 1, max = 40)
    private String password;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private Collection<PaymentModel> paymentsByStaffId;

    @ToString.Exclude
    private Collection<RentalModel> rentalsByStaffId;

    @ToString.Exclude
    private AddressModel addressByAddressId;

    @ToString.Exclude
    private StoreModel storeByStoreId;

    @ToString.Exclude
    private Collection<StoreModel> storesByStaffId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffModel that = (StaffModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(fullName, that.fullName)
                && Objects.equal(addressId, that.addressId)
                // && Objects.equal(picture, that.picture)
                && Objects.equal(email, that.email)
                && Objects.equal(storeId, that.storeId)
                && Objects.equal(active, that.active)
                && Objects.equal(username, that.username)
                && Objects.equal(password, that.password)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        // return Objects.hashCode(staffId, fullName, addressId, picture, email,
        //         storeId, active, username, password, lastUpdate);
        return Objects.hashCode(id, fullName, addressId, email,
                storeId, active, username, password, lastUpdate);
    }
}
