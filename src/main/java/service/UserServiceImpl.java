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
        if(CheckAccountID(user) != null)
            throw new RuntimeException("ID가 존재합니다.");
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
        // 유저 정보 체크
        if(loginUser == null)
            throw new RuntimeException("유저가 존재하지 않습니다.");
        else {  // 비밀번호가 같으면 성공
            if (BCrypt.checkpw(user.getPassword(), loginUser.getPassword())) {
                String token = jwtUtil.generateToken(loginUser.getID());
                return token;
            }
            else
                throw new RuntimeException("등록되지 않은 비밀번호입니다.");
        }
    }

    public User CheckAccountID(User user){
        return userMapper.CheckAccountID(user.getAccountID());
    }
}
