package gov.iti.jets.model.entity.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "film_category")
@Table(name = "film_category", schema = "sakila")
@IdClass(FilmCategoryEntityPK.class)
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FilmCategoryEntity extends BaseEntity<FilmCategoryEntity> implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;

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
    @NotNull
    private Category categoryId;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private FilmEntity filmByFilmId;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    @NotNull
    @ToString.Exclude
    private CategoryEntity categoryByCategoryId;

    public void update(FilmCategoryEntity entity) {
        this.categoryId = entity.categoryId;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryEntity that = (FilmCategoryEntity) o;
        return Objects.equal(filmId, that.filmId)
                && categoryId == that.categoryId
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, categoryId, lastUpdate);
    }
}
