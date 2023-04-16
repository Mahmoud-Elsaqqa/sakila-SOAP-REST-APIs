package gov.iti.jets.model.dto.extra;

import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Country;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.mapping.converter.CountryConverter;
import jakarta.persistence.Convert;
import lombok.*;
import lombok.experimental.FieldNameConstants;

/**
 * The staff detail model provides address and store information for staff members.
 */
@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffDetailsModel extends BaseModel {
    /**
     * staff id
     */
    private Integer id;

    /**
     * staff name (first + last)
     */
    private String name;

    /**
     * address
     */
    private String address;

    /**
     * postal code
     */
    private String zipCode;

    /**
     * phone number
     */
    private String phone;

    /**
     * city
     */
    private String city;

    /**
     * country
     */
    @Convert(converter = CountryConverter.class)
    private Country country;

    /**
     * store id
     */
    private Integer sid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDetailsModel that = (StaffDetailsModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(name, that.name)
                && Objects.equal(address, that.address)
                && Objects.equal(zipCode, that.zipCode)
                && Objects.equal(phone, that.phone)
                && Objects.equal(city, that.city)
                && country == that.country
                && Objects.equal(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, address, zipCode, phone, city, country, sid);
    }
}
