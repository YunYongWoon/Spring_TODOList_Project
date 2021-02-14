package repository;

import domain.TODOList;
import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TODOMapper {
    boolean Create(TODOList todoList);
    List<TODOList> Read(Long id);
    boolean Update(TODOList todoList);
    boolean Delete(Long id);
}
