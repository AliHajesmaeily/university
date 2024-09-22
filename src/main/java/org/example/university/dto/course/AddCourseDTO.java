package org.example.university.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.university.dto.base.AddBaseDTO;

@Getter
@Setter
public class AddCourseDTO extends AddBaseDTO {

    @Positive
    private int code;

    @NotBlank
    private String title;

    @Positive
    private int units;

}
