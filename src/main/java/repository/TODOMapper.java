package repository;

import domain.ArchieveList;
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
    void Achieve(ArchieveList archieveList);

    void checkScheduleTrue(Long id);
    void checkScheduleFalse(Long id);
    TODOList readArchieve(Long user_id);
    void deleteArchieve(Long id);
    TODOList checkList(Long id);
}
