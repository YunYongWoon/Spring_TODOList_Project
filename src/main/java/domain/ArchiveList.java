package domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ArchiveList {
    Long id;
    @NotNull(message = "TodoType이 선택되지 않았습니다.")
    TODOList.TodoType todoType;
    @NotNull(message = "Todo가 입력되지 않았습니다.")
    String todo;
    @NotNull(message = "user_ID가 입력되지 않았습니다.")
    Long user_ID;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp scheduled_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp created_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TODOList.TodoType getTodoType() {
        return todoType;
    }

    public void setTodoType(TODOList.TodoType todoType) {
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
}
