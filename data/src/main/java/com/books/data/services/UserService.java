package com.books.data.services;

import com.books.data.entities.User;

public interface UserService {

      User findUserByEmail(String email) ;
     public User saveUser(User user);
}
