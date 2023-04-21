package gov.iti.jets.model.dto.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.Size;
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
@AllArgsConstructor
@XmlRootElement
public class CategoryModel extends BaseModel {
    @Convert(converter = CategoryConverter.class)
    private Category id;

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
        return id == that.id
                && Objects.equal(name, that.name)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, lastUpdate);
    }
}
