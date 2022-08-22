package com.example.GoGOQr.Service;

import com.example.GoGOQr.Model.User;

import java.util.List;

public interface UserService {
    User findUserById (long id );
    User Login(String email, String password);
    void register(User u);
    void UpdateUser(User u);
    List<User> ListAllUsers();
    void deleteUser();
    boolean isUserexists(User u);
}
