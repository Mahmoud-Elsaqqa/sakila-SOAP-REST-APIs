package gov.iti.jets.model.dto.extra;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDetailsModel extends BaseDto {
    private Integer id;

    private String store;

    private String manager;

    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDetailsModel that = (StoreDetailsModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(store, that.store)
                && Objects.equal(manager, that.manager)
                && Objects.equal(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, store, manager, address);
    }
}
