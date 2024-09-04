//package africa.semicolon.com.quagga.controllers;
//
//import africa.semicolon.com.quagga.data.models.Category;
//import africa.semicolon.com.quagga.data.models.Role;
//import africa.semicolon.com.quagga.dtos.request.LoginRequest;
//import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//
//    @Autowired private ObjectMapper objectMapper;
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void testGetQuaggaUser() {
//        try {
//            mockMvc.perform(get("/api/v1/user?userId=200"))
//                    .andExpect(status().is2xxSuccessful())
//                    .andDo(print());
//        } catch (Exception exception) {
//            assertThat(exception).isNotNull();
//        }
//    }
//    @Test
//    void testUserCanRegisterAndLogin()throws Exception{
//        mockMvc.perform(post("/api/v1/quagga/client/register")
//                .content(objectMapper.writeValueAsString(new RegisterRequest("first", "lastname","email@email.com","password","", Role.CLIENT,""
//                ,"","","", Category.MARINE,"1234567890")))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//        mockMvc.perform(post("/api/v1/quagga/client/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new LoginRequest("email@email.com","password"))))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
