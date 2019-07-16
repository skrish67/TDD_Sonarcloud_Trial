package com.example.detailstest.controller;


import com.example.detailstest.controller.UserDetailsController;
import com.example.detailstest.model.UserDetails;
import com.example.detailstest.service.UserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserDetailsController.class)
@AutoConfigureMockMvc
public class UserDetailsControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Mock
    UserDetailsService userDetailsService;

    @MockBean
    UserDetails userDetails;

    @InjectMocks
    UserDetailsController userDetailsController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userDetailsController).build();
    }

    @Test
    public void getUserDetailsShouldReturnUserDetails() throws Exception {

        //creat a mockbean for the service class which is use dby the controller to get the data using given

        UserDetails userDetails = new UserDetails();
        userDetails.setName("test1");
        userDetails.setAge("12");
        given(userDetailsService.getUserDetails("test1")).willReturn(userDetails);

        mockMvc.perform(MockMvcRequestBuilders.get("/details/{name}", "test1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("test1"))
        .andExpect(jsonPath("age").value("12"));
    }

    @Test
    public void deleteUserDeletesUserDetails() throws Exception {

        given(userDetailsService.deleteUserDetails(anyString())).willReturn("deleted");
        mockMvc.perform(MockMvcRequestBuilders.delete("/details/{name}", "test1"))
                .andExpect((status().isOk()));


    }

    @Test
    public void createUser() throws Exception {

        UserDetails userDetails = new UserDetails();
        userDetails.setName("test2");
        userDetails.setAge("13");

        String json= new ObjectMapper().writeValueAsString(userDetails);
        Mockito.when(userDetailsService.createUser(userDetails)).thenReturn("created");
        mockMvc.perform(MockMvcRequestBuilders.post("/details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect((status().isOk()));

    }

    @Test
    public void updateUserDeatils() throws Exception {

        UserDetails userDetails = new UserDetails();
        userDetails.setName("test2");
        userDetails.setAge("13");

        String json= new ObjectMapper().writeValueAsString(userDetails);
        Mockito.when(userDetailsService.updateDetails(userDetails)).thenReturn("updated");
        mockMvc.perform(MockMvcRequestBuilders.put("/details/{name}", "test2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect((status().isOk()));

    }
}
