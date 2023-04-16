package gov.iti.jets.model.entity.request;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseRequestModel;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;

    @Getter
    @Setter
    @ToString
    @FieldNameConstants
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class ActorRequestModel extends BaseRequestModel implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @JsonbProperty("firstName")
        private String firstName;

        @JsonbProperty("lastName")
        private String lastName;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ActorRequestModel that = (ActorRequestModel) o;
            return Objects.equal(firstName, that.firstName)
                    && Objects.equal(lastName, that.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(firstName, lastName);
        }
}
