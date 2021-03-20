package domain;


import javax.validation.constraints.NotNull;

public class Paging {
    @NotNull(message = "userID가 입력되지 않았습니다")
    Long user_ID;
    @NotNull(message = "pageStart가 입력되지 않았습니다")
    Long pageStart;
    @NotNull(message = "listCnt가 입력되지 않았습니다")
    int listCnt;

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

    public int getListCnt() {
        return listCnt;
    }

    public void setListCnt(int listCnt) {
        this.listCnt = listCnt;
    }
}
