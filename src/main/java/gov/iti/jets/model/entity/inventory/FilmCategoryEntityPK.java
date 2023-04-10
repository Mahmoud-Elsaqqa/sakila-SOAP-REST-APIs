package gov.iti.jets.model.entity.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class FilmCategoryEntityPK implements Serializable {
    @Id
    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    @Id
    @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED", nullable = false,
            insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Convert(converter = CategoryConverter.class)
    private Category categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryEntityPK that = (FilmCategoryEntityPK) o;
        return Objects.equal(filmId, that.filmId)
                && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, categoryId);
    }
}
