package gov.iti.jets.model.entity.customer;

import com.google.common.base.Objects;
import gov.iti.jets.model.entity.*;
import gov.iti.jets.model.entity.rental.PaymentEntity;
import gov.iti.jets.model.entity.rental.RentalEntity;
import gov.iti.jets.model.entity.rental.StoreEntity;
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

@Entity(name = "customer")
@Table(name = "customer", schema = "sakila", indexes = {
        @Index(name = "idx_fk_store_id", columnList = "store_id"),
        @Index(name = "idx_fk_address_id", columnList = "address_id"),
        @Index(name = "idx_last_name", columnList = "last_name")
})
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CustomerEntity extends BaseEntity<CustomerEntity> implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer storeId;

    @Embedded
    private FullName fullName;

    @Basic
    @Column(name = "email", length = 50, nullable = true)
    @Size(min = 1, max = 50)
    private String email;

    @Basic
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer addressId;

    @Basic
    @Column(name = "active", columnDefinition = "BOOLEAN", nullable = false)
    @ColumnDefault("TRUE")
    @NotNull
    private Boolean active;

    @Basic
    @Column(name = "create_date", columnDefinition = "DATETIME", nullable = false)
    @NotNull
    private LocalDateTime createDate;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = true)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private StoreEntity storeByStoreId;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private AddressEntity addressByAddressId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerByCustomerId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<PaymentEntity> paymentsByCustomerId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerByCustomerId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<RentalEntity> rentalsByCustomerId;

    public void update(CustomerEntity entity) {
        this.storeId = entity.getStoreId();
        this.fullName = entity.getFullName();
        this.email = entity.getEmail();
        this.addressId = entity.getAddressId();
        this.active = entity.getActive();
        this.createDate = entity.getCreateDate();
        this.lastUpdate = entity.getLastUpdate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
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
        return Objects.hashCode(id, storeId, fullName, email, addressId, active,
                createDate, lastUpdate);
    }
}
