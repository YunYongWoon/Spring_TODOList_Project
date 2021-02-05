package domain;

import java.math.BigInteger;
import java.sql.Timestamp;

public class TODO_List {
    Integer idx;
    enum type{TODO,Progress,Done}
    String todo;
    Long user_ID;
    Timestamp due_Time;
    Timestamp created_at;
    Timestamp updated_at;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Long user_ID) {
        this.user_ID = user_ID;
    }

    public Timestamp getDue_Time() {
        return due_Time;
    }

    public void setDue_Time(Timestamp due_Time) {
        this.due_Time = due_Time;
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
