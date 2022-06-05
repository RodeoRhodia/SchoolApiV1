package schoolManagerV1.school.student;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration (locations = "")
@WebAppConfiguration(value = "")
@SpringBootTest
class StudentControllerTest {

    private MockMvc mockMvc;
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void getStudents() throws Exception {
        ServletContext servletContext = webApplicationContext.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull((StudentController) webApplicationContext.getBean(StudentController.class));

        RequestBuilder request = MockMvcRequestBuilders.get("/students");
        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        String jsonString = mvcResult.getResponse().getContentAsString();

        Object dataObject = JsonPath.parse(jsonString).read("$[0]['name']");
        String dataString = dataObject.toString();

        assertTrue(dataString.equals("Johnny Depp"));

    }

    @Test
    void getSubjects() {
    }

    @Test
    void createStudent() {
    }

    @Test
    void deleteStudent() {
    }
}