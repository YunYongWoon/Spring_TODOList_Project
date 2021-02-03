package domain;

import java.sql.Timestamp;

public class User {
    int idx;
    String ID;
    String password;
    String DB_name;
    Timestamp created_at;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDB_name() {
        return DB_name;
    }

    public void setDB_name(String DB_name) {
        this.DB_name = DB_name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
