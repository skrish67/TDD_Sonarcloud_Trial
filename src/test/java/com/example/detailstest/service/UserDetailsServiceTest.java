package com.example.detailstest.service;

import com.example.detailstest.dao.DetailsDao;
import com.example.detailstest.model.UserDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserDetailsService.class)
@AutoConfigureMockMvc
public class UserDetailsServiceTest {

    @Mock
    DetailsDao detailsDaoImpl;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
     UserDetailsService userDetailsService;

//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userDetailsService).build();
//    }

    @Test
    public void getUserDetailsTest() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("name1");
        userDetails.setAge("12");
        Mockito.when(detailsDaoImpl.getUserDetails("name1")).thenReturn(userDetails);
        UserDetails userDetailsListTest = userDetailsService.getUserDetails("name1");
        Mockito.verify(detailsDaoImpl).getUserDetails("name1");
        Assert.assertEquals(userDetails, userDetailsListTest);
    }


    @Test
    public void deleteUserDetailsTest() {
        Mockito.when(detailsDaoImpl.deleteUserDetails("name1")).thenReturn("deleted");
        String result = userDetailsService.deleteUserDetails("name1");
        Mockito.verify(detailsDaoImpl).deleteUserDetails("name1");
        Assert.assertEquals(result, "deleted");
    }


    @Test
    public void addUserDetailsTest() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("test1");
        userDetails.setAge("12");
        Mockito.when(detailsDaoImpl.createUser(userDetails)).thenReturn(("created"));
        String result = userDetailsService.createUser(userDetails);
        Mockito.verify(detailsDaoImpl).createUser(userDetails);
        Assert.assertEquals(result, "created");
    }

    @Test
    public void updateUserFDetailsTest() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("test1");
        userDetails.setAge("12");
        Mockito.when(detailsDaoImpl.updateDetails(userDetails)).thenReturn(("updated"));
        String result = userDetailsService.updateDetails(userDetails);
        Mockito.verify(detailsDaoImpl).updateDetails(userDetails);
        Assert.assertEquals(result, "updated");
    }
}

