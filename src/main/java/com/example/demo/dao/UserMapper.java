package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserMapper {

     List<User> getAllUser();

     int insertUser(User user);

     int updateUser(User user);

     int deleteUserById(Integer id);

     User getUserById(Integer id);

}
