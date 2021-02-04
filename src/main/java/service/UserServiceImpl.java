package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean RegisterUser(User user) {
        return userMapper.Register(user) == true;
    }

    @Override
    public boolean Login(User user) {
        User loginUser = userMapper.Login(user);
        if(loginUser.getPassword().equals(user.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
}
