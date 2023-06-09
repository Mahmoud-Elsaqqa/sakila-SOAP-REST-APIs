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

@Entity(name = "city")
@Table(name = "city", schema = "sakila", indexes = {
        @Index(name = "idx_fk_country_id", columnList = "country_id")
})
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CityEntity extends BaseEntity<CityEntity> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "city_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "city", length = 50, nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String city;

    @Basic
    @Column(name = "country_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @Convert(converter = CountryConverter.class)
    @NotNull
    private Country countryId;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "cityByCityId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<AddressEntity> addressesByCityId;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private CountryEntity countryByCountryId;

    public void update(CityEntity entity) {
        this.city = entity.city;
        this.countryId = entity.countryId;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
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
