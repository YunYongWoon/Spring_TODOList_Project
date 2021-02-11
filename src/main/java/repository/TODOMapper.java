package repository;

import domain.TODOList;
import domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface TODOMapper {
    boolean Create(TODOList todoList);
    void Read(User user);
    void Update();
    void Delete();
}
