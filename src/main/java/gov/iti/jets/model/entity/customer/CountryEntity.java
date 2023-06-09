package gov.iti.jets.model.entity.customer;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Country;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.mapping.converter.CountryConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "country")
@Table(name = "country", schema = "sakila")
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CountryEntity extends BaseEntity<CountryEntity> implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "country_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Convert(converter = CountryConverter.class)
    private Country id;

    @Basic
    @Column(name = "country", length = 50, nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String country;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "countryByCountryId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<CityEntity> citiesByCountryId;

    public void update(CountryEntity entity) {
        this.country = entity.country;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return id == that.id
                && Objects.equal(country, that.country)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, country, lastUpdate);
    }
}
