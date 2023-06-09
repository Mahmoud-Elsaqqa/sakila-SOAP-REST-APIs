package gov.iti.jets.model.entity.inventory;

import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "category")
@Table(name = "category", schema = "sakila")
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryEntity extends BaseEntity<CategoryEntity> implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Convert(converter = CategoryConverter.class)
    private Category id;

    @Basic
    @Column(name = "name", length = 25, nullable = false)
    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "categoryByCategoryId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<FilmCategoryEntity> filmCategoriesByCategoryId;

    public void update(CategoryEntity entity) {
        this.name = entity.name;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id
                && Objects.equal(name, that.name)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, lastUpdate);
    }
}
