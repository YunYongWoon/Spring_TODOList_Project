package domain;


import javax.validation.constraints.NotNull;

public class Paging {
    @NotNull(message = "userID가 입력되지 않았습니다")
    Long user_ID;
    @NotNull(message = "pageStart가 입력되지 않았습니다")
    Long pageStart;
    @NotNull(message = "listCnt가 입력되지 않았습니다")
    private int totalListInPage = 5;

    private int totalListCnt;
    private int totalPageCnt;
    private Long startList;

    public Long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Long user_ID) {
        this.user_ID = user_ID;
    }

    public Long getPageStart() {
        return pageStart;
    }

    public void setPageStart(Long pageStart) {
        this.pageStart = pageStart;
    }

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
        setPageStart(start);
    }
}
