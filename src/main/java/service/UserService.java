package service;

import domain.User;

public interface UserService {
    boolean RegisterUser(User user);
    boolean Login(User user);
}
