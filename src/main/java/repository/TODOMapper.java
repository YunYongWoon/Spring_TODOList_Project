package repository;

import domain.TODOList;
import domain.User;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TODOMapper {
    void Create(TODOList todoList);
    List<TODOList> Read(Long user_id);
    void Update(TODOList todoList);
    void Delete(Long id);
    void checkScheduleTrue(Long id);
    void checkScheduleFalse(Long id);
    Timestamp getTime(Long user_id);
    void Achieve(Long id);
    List<TODOList> readArchieve(Long user_id);
}
