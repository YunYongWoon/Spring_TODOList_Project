package repository;

import domain.ArchiveList;
import domain.Paging;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveMapper {
    List<ArchiveList> Read(Paging paging);
    int getCount(Long user_id);
}
