package gov.iti.jets.model.entity.rental;

import com.google.common.base.Objects;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.entity.customer.AddressEntity;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.model.entity.inventory.InventoryEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "store")
@Table(name = "store", schema = "sakila", indexes = {
        @Index(name = "idx_unique_manager", columnList = "manager_staff_id", unique = true),
        @Index(name = "idx_fk_address_id", columnList = "address_id")
})
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreEntity extends BaseEntity<StoreEntity> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "manager_staff_id", columnDefinition = "TINYINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer managerStaffId;

    @Basic
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer addressId;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "storeByStoreId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonbTransient
    private Collection<CustomerEntity> customersByStoreId;

    @OneToMany(mappedBy = "storeByStoreId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonbTransient
    private Collection<InventoryEntity> inventoriesByStoreId;

    @OneToMany(mappedBy = "storeByStoreId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonbTransient
    private Collection<StaffEntity> staffByStoreId;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private StaffEntity staffByManagerStaffId;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private AddressEntity addressByAddressId;

    public void update(StoreEntity entity) {
        this.managerStaffId = entity.managerStaffId;
        this.addressId = entity.addressId;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreEntity that = (StoreEntity) o;
        return Objects.equal(id, that.id)
                && Objects.equal(managerStaffId, that.managerStaffId)
                && Objects.equal(addressId, that.addressId)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, managerStaffId, addressId, lastUpdate);
    }
}
