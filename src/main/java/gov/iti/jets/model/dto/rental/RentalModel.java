package gov.iti.jets.model.dto.rental;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.dto.customer.CustomerModel;
import gov.iti.jets.model.dto.inventory.InventoryModel;
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
public class RentalModel extends BaseDto {
    private Integer id;

    private LocalDateTime rentalDate;

    private Integer inventoryId;

    private Integer customerId;

    private LocalDateTime returnDate;

    private Integer staffId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private Collection<PaymentModel> paymentsByRentalId;

    @ToString.Exclude
    private InventoryModel inventoryByInventoryId;

    @ToString.Exclude
    private CustomerModel customerByCustomerId;

    @ToString.Exclude
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
