package gov.iti.jets.model.dto.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.Size;
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
public class CategoryModel extends BaseDto {
    @Convert(converter = CategoryConverter.class)
    private Category categoryId;

    @Size(min = 1, max = 25)
    private String name;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    @JsonbTransient
    private Collection<FilmCategoryModel> filmCategoriesByCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return categoryId == that.categoryId
                && Objects.equal(name, that.name)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoryId, name, lastUpdate);
    }
}