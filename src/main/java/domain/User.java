package domain;

import javax.validation.constraints.*;
import java.sql.Timestamp;

public class User {
    Long ID;
    @Size(min=6,max=16)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    String accountID;
    @Size(min=6,max=16)
    @Pattern(regexp = "[a-zA-Z0-9~!@#$%^&*()]+")
    String password;
    Timestamp created_at;
    Timestamp updated_at;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
