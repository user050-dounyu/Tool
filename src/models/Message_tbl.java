package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_tbl")
public class Message_tbl {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "message_contents", length = 300, nullable = false)
    private String message_contents;

    @Column(name = "user_id", length = 100, nullable = false)
    private int user_id;

    @Column(name = "category_id", length = 100)
    private int category_id;

    @Column(name = "status_id", length = 100)
    private int status_id;

    @Column(name = "message_time")
    private Timestamp message_time;

    public Integer getMessageId() {
        return message_id;
    }

    public void setMessageId(Integer message_id) {
        this.message_id = message_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageContents() {
        return message_contents;
    }

    public void setMessageContents(String message_contents) {
        this.message_contents = message_contents;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public int getStatusId() {
        return status_id;
    }

    public void setStatusId(int status_id) {
        this.status_id = status_id;
    }

    public Timestamp getMessageTime() {
        return message_time;
    }

    public void setMessageTime(Timestamp message_time) {
        this.message_time = message_time;
    }



}
