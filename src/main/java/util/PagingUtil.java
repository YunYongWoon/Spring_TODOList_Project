package util;

import org.springframework.stereotype.Component;

@Component
public class PagingUtil {
    private int totalListCnt;
    private int totalPageCnt;
    private int totalListInPage = 5;
    private Long startList;

    public int getTotalListCnt() {
        return totalListCnt;
    }

    public void setTotalListCnt(int totalListCnt) {
        this.totalListCnt = totalListCnt;
        setTotalPageCnt(totalListCnt);
    }

    public int getTotalPageCnt() {
        return totalPageCnt;
    }

    public void setTotalPageCnt(int totalPageCnt) {
        this.totalPageCnt = totalPageCnt / totalListInPage + 1;
    }

    public int getTotalListInPage() {
        return totalListInPage;
    }

    public void setTotalListInPage(int totalListInPage) {
        this.totalListInPage = totalListInPage;
    }

    public Long getStartList() {
        return startList;
    }

    public void setStartList(Long startList) {
        Long start = (startList * getTotalListInPage()) - getTotalListInPage();
        this.startList = start;
    }
}
