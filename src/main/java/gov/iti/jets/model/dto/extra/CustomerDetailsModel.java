package gov.iti.jets.model.dto.extra;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Country;
import gov.iti.jets.model.mapping.converter.CountryConverter;
import jakarta.persistence.Convert;
import lombok.*;
import lombok.experimental.FieldNameConstants;

/**
 * The customer detail model provides a list of customers, with name and address.
 */
@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsModel {
    /**
     * customer id
     */
    private Integer id;

    /**
     * customer name (first + last)
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
     * notes (whether the customer is active)
     */
    private String notes;

    /**
     * store id
     */
    private Integer sid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetailsModel that = (CustomerDetailsModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(name, that.name)
                && Objects.equal(address, that.address)
                && Objects.equal(zipCode, that.zipCode)
                && Objects.equal(phone, that.phone)
                && Objects.equal(city, that.city)
                && country == that.country
                && Objects.equal(notes, that.notes)
                && Objects.equal(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, address, zipCode, phone, city, country, notes, sid);
    }
}
