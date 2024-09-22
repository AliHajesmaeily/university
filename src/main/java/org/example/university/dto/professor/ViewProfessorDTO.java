package org.example.university.dto.professor;

import lombok.Getter;
import lombok.Setter;
import org.example.university.dto.user.ViewUserDTO;

import java.util.List;
@Getter
@Setter
public class ViewProfessorDTO extends ViewUserDTO {

    private long code;
    private String academicRank;
    private List<Integer> courseCodes;

}
