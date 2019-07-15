package com.library.library.services;

import com.library.library.entities.User;

public interface UserService {

      User findUserByEmail(String email) ;
     public User saveUser(User user);
}
