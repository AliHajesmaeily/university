package org.example.university.dto.Student;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.university.dto.user.UpdateUserDTO;

@Getter
@Setter
public class UpdateStudentDTO extends UpdateUserDTO {
    @NotBlank
    private String academicLevel;
}


