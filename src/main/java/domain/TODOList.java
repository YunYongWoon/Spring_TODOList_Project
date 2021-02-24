package domain;

import java.sql.Timestamp;
import java.util.Date;

public class TODOList {
    Long id;
    TodoType todoType;
    String todo;
    Long user_ID;
    Timestamp scheduled_at;
    Timestamp created_at;
    Timestamp updated_at;
    boolean is_deleted;
    boolean is_finished;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getScheduled_at() {
        return scheduled_at;
    }

    public void setScheduled_at(Timestamp scheduled_at) {
        this.scheduled_at = scheduled_at;
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

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public boolean isIs_finished() {
        return is_finished;
    }

    public void setIs_finished(boolean is_finished) {
        this.is_finished = is_finished;
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
