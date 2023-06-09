package gov.iti.jets.model.entity.rental;

import com.google.common.base.Objects;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.entity.customer.CustomerEntity;
import gov.iti.jets.model.entity.inventory.InventoryEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "rental")
@Table(name = "rental", schema = "sakila", indexes = {
        @Index(name = "rental_date", columnList = "rental_date, inventory_id, customer_id", unique = true),
        @Index(name = "idx_fk_inventory_id", columnList = "inventory_id"),
        @Index(name = "idx_fk_customer_id", columnList = "customer_id"),
        @Index(name = "idx_fk_staff_id", columnList = "staff_id")
})
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RentalEntity extends BaseEntity<RentalEntity> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rental_id", columnDefinition = "INT", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "rental_date", columnDefinition = "DATETIME", nullable = false)
    @NotNull
    private LocalDateTime rentalDate;

    @Basic
    @Column(name = "inventory_id", columnDefinition = "MEDIUMINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer inventoryId;

    @Basic
    @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer customerId;

    @Basic
    @Column(name = "return_date", columnDefinition = "DATETIME", nullable = true)
    @ColumnDefault("NULL")
    private LocalDateTime returnDate;

    @Basic
    @Column(name = "staff_id", columnDefinition = "TINYINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer staffId;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "rentalByRentalId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<PaymentEntity> paymentsByRentalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private InventoryEntity inventoryByInventoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private CustomerEntity customerByCustomerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private StaffEntity staffByStaffId;

    public void update(RentalEntity entity) {
        this.rentalDate = entity.rentalDate;
        this.inventoryId = entity.inventoryId;
        this.customerId = entity.customerId;
        this.returnDate = entity.returnDate;
        this.staffId = entity.staffId;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalEntity that = (RentalEntity) o;
        return Objects.equal(id, that.id)
                && Objects.equal(rentalDate, that.rentalDate)
                && Objects.equal(inventoryId, that.inventoryId)
                && Objects.equal(customerId, that.customerId)
                && Objects.equal(returnDate, that.returnDate)
                && Objects.equal(staffId, that.staffId)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
    }
}
