package service;

import domain.User;

public interface UserService {
    boolean RegisterUser(User user);
    String Login(User user);
}
