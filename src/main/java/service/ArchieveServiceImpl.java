package service;

import domain.ArchieveList;
import domain.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ArchieveMapper;
import sun.jvm.hotspot.utilities.IntArray;
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
    @Transactional
    public List<ArchieveList> ReadList(Long currentPage) {
        Long user_id = jwtUtil.getIdByToken();
        if(currentPage == null)
            throw new RuntimeException("currentPage 값이 없습니다");

        pagingUtil.setTotalListCnt(getTotalCnt(user_id));
        pagingUtil.setStartList(currentPage);

        Long pageStart = pagingUtil.getStartList();
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
