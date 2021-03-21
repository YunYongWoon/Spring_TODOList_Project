package service;

import domain.ArchiveList;
import domain.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArchiveMapper;
import util.JwtUtil;

import java.util.List;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    ArchiveMapper archiveMapper;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public List<ArchiveList> ReadList(Long currentPage) {
        if(currentPage == null)
            throw new RuntimeException("currentPage 값이 없습니다");
        jwtUtil.getIdByToken();
        Paging paging = new Paging();
        paging.setTotalListCnt(getTotalCnt(jwtUtil.getIdByToken()));

        if(currentPage < 1 || currentPage > paging.getTotalPageCnt())
            throw new RuntimeException("잘못된 페이지 정보입니다.");

        paging.setStartList(currentPage);
        paging.setUser_ID(jwtUtil.getIdByToken());

        return archiveMapper.Read(paging);
    }

    public int getTotalCnt(Long user_id){
        return archiveMapper.getCount(user_id);
    }

}
