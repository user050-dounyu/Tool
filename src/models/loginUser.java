package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "user_tbl")
public class loginUser {
    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "user_name", length = 100, nullable = true)
    private String user_name;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "auth_id", nullable = true)
    private Integer auth_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }
}
