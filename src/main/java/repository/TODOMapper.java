package repository;

import domain.TODOList;
import domain.User;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TODOMapper {
    boolean Create(TODOList todoList);
    List<TODOList> Read(Long user_id);
    boolean Update(TODOList todoList);
    boolean Delete(Long id);
    Timestamp getTime(Long user_id);
    boolean Achieve(Long id);
    List<TODOList> readArchieve(Long user_id);
}
