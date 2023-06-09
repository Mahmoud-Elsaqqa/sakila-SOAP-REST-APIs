package gov.iti.jets.model.entity.rental;

import com.google.common.base.Objects;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.entity.FullName;
import gov.iti.jets.model.entity.customer.AddressEntity;
import jakarta.json.bind.annotation.JsonbTransient;
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

@Entity(name = "staff")
@Table(name = "staff", schema = "sakila", indexes = {
        @Index(name = "idx_fk_store_id", columnList = "store_id"),
        @Index(name = "idx_fk_address_id", columnList = "address_id")
})
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StaffEntity extends BaseEntity<StaffEntity> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "staff_id", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private FullName fullName;

    @Basic
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer addressId;

    // @Basic
    // @Column(name = "picture", columnDefinition = "BLOB", nullable = true)
    // @ColumnDefault("NULL")
    // @Lob
    // private byte[] picture;

    @Basic
    @Column(name = "email", length = 50, nullable = true)
    @ColumnDefault("NULL")
    @Size(min = 1, max = 50)
    private String email;

    @Basic
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @NotNull
    private Integer storeId;

    @Basic
    @Column(name = "active", columnDefinition = "BOOLEAN", nullable = false)
    @ColumnDefault("TRUE")
    @NotNull
    private Boolean active;

    @Basic
    @Column(name = "username", length = 16, nullable = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String username;

    @Basic
    @Column(name = "password", columnDefinition = "VARCHAR(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin", length = 40, nullable = true)
    @ColumnDefault("NULL")
    @Size(min = 1, max = 40)
    private String password;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "staffByStaffId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonbTransient
    private Collection<PaymentEntity> paymentsByStaffId;

    @OneToMany(mappedBy = "staffByStaffId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonbTransient
    private Collection<RentalEntity> rentalsByStaffId;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private AddressEntity addressByAddressId;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private StoreEntity storeByStoreId;

    @OneToMany(mappedBy = "staffByManagerStaffId", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonbTransient
    private Collection<StoreEntity> storesByStaffId;

    public void update(StaffEntity entity) {
        this.fullName = entity.fullName;
        this.addressId = entity.addressId;
        // this.picture = entity.picture;
        this.email = entity.email;
        this.storeId = entity.storeId;
        this.active = entity.active;
        this.username = entity.username;
        this.password = entity.password;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return Objects.equal(id, that.id)
                && Objects.equal(fullName, that.fullName)
                && Objects.equal(addressId, that.addressId)
                // && Objects.equal(picture, that.picture)
                && Objects.equal(email, that.email)
                && Objects.equal(storeId, that.storeId)
                && Objects.equal(active, that.active)
                && Objects.equal(username, that.username)
                && Objects.equal(password, that.password)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        // return Objects.hashCode(staffId, fullName, addressId, picture, email,
        //         storeId, active, username, password, lastUpdate);
        return Objects.hashCode(id, fullName, addressId, email,
                storeId, active, username, password, lastUpdate);
    }
}
