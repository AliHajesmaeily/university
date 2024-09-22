package org.example.university.dto.professor;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.example.university.dto.user.UpdateUserDTO;

@Setter
@Getter
public class UpdateProfessorDTO extends UpdateUserDTO {
    @Positive
    private int code;

    @NotBlank
    private String academicRank;

}
