package skillbox.diploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ApiPostController.class)
class ApiPostControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getPosts() {
    }
}