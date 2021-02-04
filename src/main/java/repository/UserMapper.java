package repository;

import domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    boolean Register(User user);
    User Login(User user);
}
