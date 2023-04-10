package gov.iti.jets.model.dto.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.dto.rental.RentalModel;
import gov.iti.jets.model.dto.rental.StoreModel;
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
public class InventoryModel extends BaseDto {
    private Integer id;

    private Integer filmId;

    private Integer storeId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private FilmModel filmByFilmId;

    @ToString.Exclude
    private StoreModel storeByStoreId;

    @ToString.Exclude
    private Collection<RentalModel> rentalsByInventoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryModel that = (InventoryModel) o;
        return Objects.equal(id, that.id)
                && Objects.equal(filmId, that.filmId)
                && Objects.equal(storeId, that.storeId)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, filmId, storeId, lastUpdate);
    }
}
