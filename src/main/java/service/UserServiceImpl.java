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

    //회원가입
    @Override
    public void RegisterUser(User user) {
        if(CheckID(user) != null)
            throw new RuntimeException("ID is exist");
        else {
            String bcryptPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(bcryptPassword);
            userMapper.Register(user);
        }
    }

    // 로그인
    @Override
    public String Login(User user) {
        User loginUser = userMapper.Login(user);
        // 비밀번호가 같으면 성공
        if(loginUser == null)
            throw new RuntimeException("User is not exist");
        else {
            if (BCrypt.checkpw(user.getPassword(), loginUser.getPassword())) {
                String token = jwtUtil.generateToken(loginUser.getID());
                return token;
            }
            else
                throw new RuntimeException("Password is Wrong");
        }
    }

    public User CheckID(User user){
        return userMapper.CheckID(user.getAccountID());
    }
}
