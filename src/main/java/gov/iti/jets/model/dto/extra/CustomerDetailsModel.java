package gov.iti.jets.model.dto.extra;


import com.google.common.base.Objects;
import java.lang.String;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.entity.FullName;
import gov.iti.jets.model.mapping.converter.CountryConverter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Convert;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.*;
import lombok.experimental.FieldNameConstants;

/**
 * The customer detail model provides a list of customers, with name and address.
 */
@Getter
@Setter
@ToString
@FieldNameConstants
@NoArgsConstructor
@XmlRootElement
@JsonbPropertyOrder({"id", "name", "email", "address", "zipCode",
        "phone", "city", "country", "sid", "storeAddress"})
public class CustomerDetailsModel extends BaseModel {
    public CustomerDetailsModel(Integer id, FullName fullName, String email, String address, String zipCode, String phone, String city, String country, Integer sid, String storeAddress) {
        this.id = id;
        this.fullName = fullName;
        this.name = fullName.getFirstName() + " " + fullName.getLastName();
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.email = email;
        this.sid = sid;
        this.storeAddress = storeAddress;
    }

    @JsonbProperty("Customer ID")
    private Integer id;

    @JsonbTransient
    private transient FullName fullName;

    @JsonbProperty("Customer Name")
    private String name;

    @JsonbProperty("Customer Address")
    private String address;

    @JsonbProperty("Customer ZIP Code")
    private String zipCode;

    @JsonbProperty("Customer Phone")
    private String phone;

    @JsonbProperty("Customer City")
    private String city;

    @Convert(converter = CountryConverter.class)
    @JsonbProperty("Customer Country")
    private String country;

    @JsonbProperty("Customer email")
    private String email;

    @JsonbProperty("Customer Store ID")
    private Integer sid;

    @JsonbProperty("Store Address")
    private String storeAddress;

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
                && Objects.equal(email, that.email)
                && Objects.equal(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, address, zipCode, phone, city, country, email, sid);
    }
}
