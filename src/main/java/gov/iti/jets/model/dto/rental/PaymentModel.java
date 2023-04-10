package gov.iti.jets.model.dto.rental;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.dto.customer.CustomerModel;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel extends BaseDto {
    private Integer id;

    private Integer customerId;

    private Integer staffId;

    private Integer rentalId;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private CustomerModel customerByCustomerId;

    @ToString.Exclude
    private StaffModel staffByStaffId;

    @ToString.Exclude
    private RentalModel rentalByRentalId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentModel that = (PaymentModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(customerId, that.customerId)
                && Objects.equal(staffId, that.staffId)
                && Objects.equal(rentalId, that.rentalId)
                && Objects.equal(amount, that.amount)
                && Objects.equal(paymentDate, that.paymentDate)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, customerId, staffId, rentalId, amount,
                paymentDate, lastUpdate);
    }
}
