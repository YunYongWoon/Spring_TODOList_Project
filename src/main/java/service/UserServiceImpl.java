package service;

import domain.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserMapper;
import util.JwtUtil;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean RegisterUser(User user) {
        String bcryptPassword = BCrypt.hashpw(user.getUser_password(),BCrypt.gensalt());
        user.setUser_password(bcryptPassword);
        return userMapper.Register(user) == true;
    }

    @Override
    public String Login(User user) {
        User loginUser = userMapper.Login(user);
        if(BCrypt.checkpw(user.getUser_password(),loginUser.getUser_password())){
            String token = jwtUtil.generateToken(loginUser.getUser_ID());
            return token;
        }
        else
            return null;
    }
}
