package domain;

import java.math.BigInteger;
import java.sql.Timestamp;

public class TODOList {

    Long idx;
    TodoType todoType;
    String todo;
    Long user_ID;
    Timestamp created_at;
    Timestamp updated_at;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public TodoType getTodoType() {
        return todoType;
    }

    public void setTodoType(TodoType todoType) {
        this.todoType = todoType;
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

    public enum TodoType{
        TODO("TODO"),Progress("Progress"),Done("Done");

        private String value;

        TodoType(String value){
            this.value = value;
        }

        public String getKey(){
            return name();
        }

        public String getValue(){
            return value;
        }
    }
}
