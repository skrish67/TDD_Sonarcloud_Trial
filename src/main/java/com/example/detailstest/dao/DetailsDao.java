package com.example.detailstest.dao;

import com.example.detailstest.model.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsDao<T, T1> {
    UserDetails getUserDetails(String name);

    String deleteUserDetails(String name);

    String createUser(UserDetails userDetails);

    String updateDetails(UserDetails userDetails);

}
