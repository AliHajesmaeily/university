package org.example.university.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.university.dto.course.AddCourseDTO;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:application-test.properties"})
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

   @Test
   public void givenValidData_whenSaveCourse_thenIsCreatedShouldBeReturn() throws Exception {
    //Given
        AddCourseDTO addCourseDTO=new AddCourseDTO();
        addCourseDTO.setCode(5);
        addCourseDTO.setTitle("junit-integration");
        addCourseDTO.setCode(6);

        //
        mockMvc.perform(post("/course/v1/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addCourseDTO)))

                //Then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(addCourseDTO.getCode()))
                .andExpect(jsonPath("$.title").value(addCourseDTO.getTitle()))
                .andExpect(jsonPath("$.units").value(addCourseDTO.getUnits()));


  }
}
