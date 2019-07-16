package com.example.detailstest.dao;

import com.example.detailstest.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DetailsDaoImpl implements DetailsDao<UserDetails, String>{

    @Override
    public UserDetails getUserDetails(String name) {
        UserDetails userDetails = new UserDetails();
        userDetails.setAge("13");
        userDetails.setName("test1");
        return userDetails;
    }

    @Override
    public String deleteUserDetails(String name) {
        return "deleted";
    }

    @Override
    public String createUser(UserDetails userDetails) {
        return "created";
    }

    @Override
    public String updateDetails(UserDetails userDetails) {
        return "updated";
    }
}
