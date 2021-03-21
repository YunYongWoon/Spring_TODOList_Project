package domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class TODOList {
    Long id;
    @NotNull(message = "TodoType이 선택되지 않았습니다.")
    TodoType todoType;
    @Size(min=1,max=200, message = "Todo의 길이가 너무 깁니다.")
    @NotNull(message = "Todo가 입력되지 않았습니다.")
    String todo;
    Long user_ID;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp scheduled_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp created_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp updated_at;
    boolean is_deleted;
    boolean is_finished;
    boolean is_archived;

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

    public Timestamp getScheduled_at() {
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

    public boolean isIs_archived() {
        return is_archived;
    }

    public void setIs_archived(boolean is_archieved) {
        this.is_archived = is_archieved;
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
