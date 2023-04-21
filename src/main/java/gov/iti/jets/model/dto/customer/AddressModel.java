package gov.iti.jets.model.dto.customer;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.rental.StaffModel;
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
@AllArgsConstructor
@XmlRootElement
public class AddressModel extends BaseModel {

    private Integer id;

    @Size(min = 1, max = 50)
    private String address;


    @Size(min = 1, max = 50)
    private String address2;


    @Size(min = 1, max = 20)
    private String district;


    private Integer cityId;


    @Size(min = 1, max = 10)
    private String postalCode;


    @Size(min = 1, max = 20)
    private String phone;

    //
    // private Point location;


    private LocalDateTime lastUpdate;

    @ToString.Exclude
    @JsonbTransient
    private CityModel cityByCityId;

    @ToString.Exclude
    @JsonbTransient
    private Collection<CustomerModel> customersByAddressId;

    @ToString.Exclude
    @JsonbTransient
    private Collection<StaffModel> staffByAddressId;

    @ToString.Exclude
    @JsonbTransient
    private Collection<StoreModel> storesByAddressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressModel that = (AddressModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(address, that.address)
                && Objects.equal(address2, that.address2)
                && Objects.equal(district, that.district)
                && Objects.equal(cityId, that.cityId)
                && Objects.equal(postalCode, that.postalCode)
                && Objects.equal(phone, that.phone)
                // && Objects.equal(location, that.location)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        // return Objects.hashCode(addressId, address, address2, district, cityId, postalCode, phone, location, lastUpdate);
        return Objects.hashCode(id, address, address2, district, cityId, postalCode, phone, lastUpdate);
    }
}
