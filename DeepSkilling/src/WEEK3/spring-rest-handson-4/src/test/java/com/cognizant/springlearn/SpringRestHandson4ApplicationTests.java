package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringRestHandson4ApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    void testAddCountryValidationException() throws Exception {
        mvc.perform(post("/countries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"code\":\"I\",\"name\":\"India\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0]").value("Country code should be 2 characters"));
    }

    @Test
    void testUpdateEmployeeException() throws Exception {
        mvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":999,\"name\":\"Not Found\",\"salary\":40000,\"permanent\":true,\"dateOfBirth\":\"01/01/2000\",\"department\":{\"id\":1,\"name\":\"Engineering\"},\"skillList\":[{\"id\":1,\"name\":\"Java\"}]}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteEmployeeException() throws Exception {
        mvc.perform(delete("/employees/999"))
                .andExpect(status().isNotFound());
    }
}
