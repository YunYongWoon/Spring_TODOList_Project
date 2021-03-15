package repository;

import domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void Register(User user);
    User Login(User user);
    User CheckAccountID(String accountID);
}
