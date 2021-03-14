package service;

import domain.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserMapper;
import util.JwtUtil;
import exception.AccountException;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    //회원가입
    @Override
    public void RegisterUser(User user) throws AccountException {
        // DB에 같은 아이디가 없으면 성공
        if(CheckID(user) != null) {
            throw new AccountException("ID is exist");
        }
        else {
            // 비밀번호 생성후 등록
            String bcryptPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(bcryptPassword);
            userMapper.Register(user);
        }
    }

    // 로그인
    @Override
    public String Login(User user) throws AccountException {
        User loginUser = userMapper.Login(user);

        // 토큰이 있으면(로그인 중) 로그인 실패. 토큰 발급 안됨.
        if(jwtUtil.getIdByToken() != null)
            throw new AccountException("Already Login");

        // 비밀번호가 같으면 성공
        if(BCrypt.checkpw(user.getPassword(),loginUser.getPassword())){
            String token = jwtUtil.generateToken(loginUser.getID());
            return token;
        }
        else
            throw new AccountException("Wrong Password");
    }


    // ID 존재유무 체크
    private User CheckID(User user){
        return userMapper.CheckID(user.getAccountID());
    }


}
