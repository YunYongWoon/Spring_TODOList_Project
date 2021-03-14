package service;

import domain.User;

public interface UserService {
    void RegisterUser(User user);
    String Login(User user);
}
