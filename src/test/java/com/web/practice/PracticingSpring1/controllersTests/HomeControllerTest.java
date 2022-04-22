package com.web.practice.PracticingSpring1.controllersTests;

import com.web.practice.PracticingSpring1.api.controllers.HomeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = HomeController.class)
@AutoConfigureMockMvc
public class HomeControllerTest {

    static final String HOME = "/";

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Must verify the home route")
    public void getHomeTest() throws Exception{
        //scene

        //execution
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(HOME);

        //verification
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
