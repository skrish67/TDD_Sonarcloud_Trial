package com.example.detailstest.service;

import com.example.detailstest.dao.DetailsDao;
import com.example.detailstest.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    DetailsDao detailsDao;

    public UserDetails getUserDetails(String name) {
        return detailsDao.getUserDetails(name);
    }
    public String deleteUserDetails(String name) {
        return detailsDao.deleteUserDetails(name);
    }
    public String createUser(UserDetails userDetails) {
        return detailsDao.createUser(userDetails);
    }
    public String updateDetails(UserDetails userDetails) {
        return detailsDao.updateDetails(userDetails);
    }
}
