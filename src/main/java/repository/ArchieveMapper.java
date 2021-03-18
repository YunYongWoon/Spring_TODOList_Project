package repository;

import domain.ArchieveList;
import domain.Paging;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchieveMapper {
    List<ArchieveList> Read(Paging paging);
    int getCount(Long user_id);
}
