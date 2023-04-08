package gov.iti.jets.model.dto.core;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Language;
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
public class LanguageModel {
    private Language languageId;

    @Size(min = 1, max = 20)
    private String name;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private Collection<FilmModel> filmsByLanguageId;

    @ToString.Exclude
    private Collection<FilmModel> filmsByOriginalLanguageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageModel that = (LanguageModel) o;
        return languageId == that.languageId
                && Objects.equal(name, that.name)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(languageId, name, lastUpdate);
    }
}
