package domain;

import java.math.BigInteger;
import java.sql.Timestamp;

public class User {
    BigInteger User_ID;
    String User_AccountID;
    String User_Password;
    Timestamp created_at;
    Timestamp updated_at;

    public BigInteger getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(BigInteger user_ID) {
        User_ID = user_ID;
    }

    public String getUser_AccountID() {
        return User_AccountID;
    }

    public void setUser_AccountID(String user_AccountID) {
        User_AccountID = user_AccountID;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
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
