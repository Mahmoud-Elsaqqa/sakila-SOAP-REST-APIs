package gov.iti.jets.model.dto;

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
public class FullName {
    @Size(min = 1, max = 45)
    private String firstName;

    @Size(min = 1, max = 45)
    private String lastName;
}
