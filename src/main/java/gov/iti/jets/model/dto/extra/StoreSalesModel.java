package gov.iti.jets.model.dto.extra;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

/**
 * The sales by store model provides the data for the total sales by store.
 */
@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreSalesModel extends BaseModel {
    /**
     * store
     */
    private String store;

    /**
     * store manager
     */
    private String manager;

    /**
     * total sales
     */
    private BigDecimal totalSales;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreSalesModel that = (StoreSalesModel) o;
        return Objects.equal(store, that.store)
                && Objects.equal(manager, that.manager)
                && Objects.equal(totalSales, that.totalSales);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(store, manager, totalSales);
    }
}
