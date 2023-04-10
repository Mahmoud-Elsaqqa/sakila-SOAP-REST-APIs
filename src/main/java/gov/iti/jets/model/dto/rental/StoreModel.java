package gov.iti.jets.model.dto.rental;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.dto.customer.AddressModel;
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
public class StoreModel extends BaseDto {
    private Integer id;

    private Integer managerStaffId;

    private Integer addressId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private Collection<CustomerModel> customersByStoreId;

    @ToString.Exclude
    private Collection<InventoryModel> inventoriesByStoreId;

    @ToString.Exclude
    private Collection<StaffModel> staffByStoreId;

    @ToString.Exclude
    private StaffModel staffByManagerStaffId;

    @ToString.Exclude
    private AddressModel addressByAddressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreModel that = (StoreModel) o;
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
