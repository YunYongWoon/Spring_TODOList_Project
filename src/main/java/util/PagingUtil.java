package util;

import org.springframework.stereotype.Component;

@Component
public class PagingUtil {
    private int totalListCnt;
    private int totalPageCnt;
    private int lastPageListCnt;
    private int totalListInPage = 10;
    private int startList;

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
        setLastPageListCnt(totalPageCnt % totalListInPage);
        this.totalPageCnt = totalPageCnt / totalListInPage + 1;
    }

    public int getLastPageListCnt() {
        return lastPageListCnt;
    }

    public void setLastPageListCnt(int lastPageListCnt) {
        this.lastPageListCnt = lastPageListCnt;
    }

    public int getTotalListInPage() {
        return totalListInPage;
    }

    public void setTotalListInPage(int totalListInPage) {
        this.totalListInPage = totalListInPage;
    }

    public int getStartList() {
        return startList;
    }

    public void setStartList(int startList) {
        int start = (startList * getTotalListInPage()) - getTotalListInPage();
        this.startList = start;
    }
}
