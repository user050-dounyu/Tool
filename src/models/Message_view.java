package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
        @NamedQuery(
               name = "getTalkMessages",
               query = "SELECT m FROM Message_view AS m WHERE m.category_id LIKE '1%' ORDER BY m.message_id DESC"
        ),

        @NamedQuery(
                name = "getQuestionMessages",
                query = "SELECT m FROM Message_view AS m WHERE m.category_id LIKE '2%' ORDER BY m.message_id DESC"
         )
})
@Table(name = "message_view")
public class Message_view {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    @Column(name = "title")
    private String title;

    @Column(name = "message_contents")
    private String message_contents;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "category_id", length = 100)
    private int category_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "status_id", length = 100)
    private int status_id;

    @Column(name = "status_name")
    private String status_name;

    @Column(name = "message_time")
    private Timestamp message_time;

    public Integer getMessageId() {
        return message_id;
    }


    public String getTitle() {
        return title;
    }


    public String getMessageContents() {
        return message_contents;
    }


    public int getUserId() {
        return user_id;
    }


    public String getUserName() {
        return user_name;
    }


    public int getCategoryId() {
        return category_id;
    }


    public String getCategoryName() {
        return category_name;
    }


    public int getStatusId() {
        return status_id;
    }


    public String getStatusName() {
        return status_name;
    }


    public Timestamp getMessageTime() {
        return message_time;
    }


}
