package gov.iti.jets.model.dto.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import jakarta.persistence.Convert;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryModel extends BaseDto {
    private Integer filmId;

    @Convert(converter = CategoryConverter.class)
    private Category categoryId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private FilmModel filmByFilmId;

    @ToString.Exclude
    private CategoryModel categoryByCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryModel that = (FilmCategoryModel) o;
        return Objects.equal(filmId, that.filmId)
                && categoryId == that.categoryId
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, categoryId, lastUpdate);
    }
}
