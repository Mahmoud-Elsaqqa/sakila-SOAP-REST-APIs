package gov.iti.jets.model.dto.rental;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.inventory.InventoryModel;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
@AllArgsConstructor
public class RentalModel extends BaseModel {
    private Integer id;

    private LocalDateTime rentalDate;

    private Integer inventoryId;

    private Integer customerId;

    private LocalDateTime returnDate;

    private Integer staffId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    @JsonbTransient
    private Collection<PaymentModel> paymentsByRentalId;

    @ToString.Exclude
    @JsonbTransient
    private InventoryModel inventoryByInventoryId;

    @ToString.Exclude
    @JsonbTransient
    private CustomerModel customerByCustomerId;

    @ToString.Exclude
    @JsonbTransient
    private StaffModel staffByStaffId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalModel that = (RentalModel) o;
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
        return Objects.hashCode(id, rentalDate, inventoryId, customerId, returnDate,
                staffId, lastUpdate);
    }
}
