package service;

import domain.ArchieveList;
import domain.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArchieveMapper;
import util.JwtUtil;
import util.PagingUtil;

import java.util.List;

@Service
public class ArchieveServiceImpl implements ArchieveService{
    @Autowired
    ArchieveMapper archieveMapper;

    @Autowired
    PagingUtil pagingUtil;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public List<ArchieveList> ReadList(int currentPage) {
        Long user_id = jwtUtil.getIdByToken();
        pagingUtil.setTotalListCnt(getTotalCnt(user_id));
        pagingUtil.setStartList(currentPage);

        int pageStart = pagingUtil.getStartList();
        int listCnt;
        if(currentPage < 1 || currentPage > pagingUtil.getTotalPageCnt())
            throw new RuntimeException("잘못된 페이지 정보입니다.");
        else if(currentPage == pagingUtil.getTotalPageCnt())
            listCnt = pagingUtil.getLastPageListCnt();
        else
            listCnt = pagingUtil.getTotalListInPage();

        Paging paging = new Paging();
        paging.setUser_ID(user_id);
        paging.setPageStart(pageStart);
        paging.setListCnt(listCnt);

        return archieveMapper.Read(paging);
    }

    public int getTotalCnt(Long user_id){
        return archieveMapper.getCount(user_id);
    }

}
