package domain;

import java.math.BigInteger;
import java.sql.Timestamp;

public class User {
    Long user_ID;
    String user_accountID;
    String user_password;
    Timestamp created_at;
    Timestamp updated_at;

    public Long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Long user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_accountID() {
        return user_accountID;
    }

    public void setUser_accountID(String user_accountID) {
        this.user_accountID = user_accountID;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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
