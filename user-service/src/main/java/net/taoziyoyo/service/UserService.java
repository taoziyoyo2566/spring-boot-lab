package net.taoziyoyo.service;


import net.taoziyoyo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByName(String name);
    List<User> getAllUsers();
}