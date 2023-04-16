package gov.iti.jets.model.dto.customer;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Country;
import gov.iti.jets.model.dto.BaseModel;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.Size;
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
public class CityModel extends BaseModel {
    private Integer id;

    @Size(min = 1, max = 50)
    private String city;

    private Country countryId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    @JsonbTransient
    private Collection<AddressModel> addressesByCityId;

    @ToString.Exclude
    @JsonbTransient
    private CountryModel countryByCountryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityModel that = (CityModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(city, that.city)
                && countryId == that.countryId
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, city, countryId, lastUpdate);
    }
}
