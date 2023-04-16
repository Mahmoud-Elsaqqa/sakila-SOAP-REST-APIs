package gov.iti.jets.model.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.io.Serializable;

/**
 * For enforcing generic type wildcard restriction
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity<T extends BaseEntity> implements Serializable {
    //    @Basic
//    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
//    @ColumnDefault("CURRENT_TIMESTAMP")
//    @UpdateTimestamp
//    @NotNull
//    private LocalDateTime lastUpdate;
//    public abstract Object getId();
    public abstract void update(T entity);
}
