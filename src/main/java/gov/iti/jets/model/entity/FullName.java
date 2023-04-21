package gov.iti.jets.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

@Embeddable
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@XmlType(name = "FullNameEntity", namespace = "FullNameE")
public class FullName {
    @Basic
    @Column(name = "first_name", length = 45, nullable = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", length = 45, nullable = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String lastName;
}
