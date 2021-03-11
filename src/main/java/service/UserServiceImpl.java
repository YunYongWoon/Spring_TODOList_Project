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
    public boolean RegisterUser(User user) {
        String bcryptPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(bcryptPassword);
        userMapper.Register(user);
        return true;
    }

    // 로그인
    @Override
    public String Login(User user) {
        User loginUser = userMapper.Login(user);
        // 비밀번호가 같으면 성공
        if(BCrypt.checkpw(user.getPassword(),loginUser.getPassword())){
            String token = jwtUtil.generateToken(loginUser.getID());
            return token;
        }
        else
            return null;
    }
}
