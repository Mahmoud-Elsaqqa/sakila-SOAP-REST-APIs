package gov.iti.jets.model.dto.inventory;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmTextModel extends BaseDto {
    private Integer filmId;

    @Size(min = 1, max = 255)
    private String title;

    @Size(max = 65535)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTextModel that = (FilmTextModel) o;
        return Objects.equal(filmId, that.filmId)
                && Objects.equal(title, that.title)
                && Objects.equal(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, title, description);
    }
}
