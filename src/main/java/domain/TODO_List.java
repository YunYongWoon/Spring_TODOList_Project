package domain;

import java.math.BigInteger;
import java.sql.Timestamp;

public class TODO_List {
    Integer idx;
    enum type{TODO,Progress,Done}
    String TODO;
    BigInteger User_ID;
    Timestamp Due_Time;
    Timestamp created_at;
    Timestamp updated_at;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getTODO() {
        return TODO;
    }

    public void setTODO(String TODO) {
        this.TODO = TODO;
    }

    public BigInteger getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(BigInteger user_ID) {
        User_ID = user_ID;
    }

    public Timestamp getDue_Time() {
        return Due_Time;
    }

    public void setDue_Time(Timestamp due_Time) {
        Due_Time = due_Time;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
