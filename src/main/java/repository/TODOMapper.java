package repository;

import domain.ArchiveList;
import domain.TODOList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TODOMapper {
    void Create(TODOList todoList);
    List<TODOList> Read(Long user_id);
    void Update(TODOList todoList);
    void Delete(Long id);
    void Archive(ArchiveList archiveList);

    void checkScheduleTrue(Long id);
    void checkScheduleFalse(Long id);
    TODOList readArchive(Long user_id);
    void deleteArchive(Long id);
    TODOList checkList(Long id);

    TODOList checkListDeleted(Long id);
}

