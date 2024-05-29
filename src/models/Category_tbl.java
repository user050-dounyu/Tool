package models;

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
               name = "getCategory",
               query = "SELECT c FROM Category_tbl AS c ORDER BY c.category_id DESC"
        )
})
@Table(name = "category_tbl")

public class Category_tbl {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;

    @Column(name = "pre_category_id")
    private int pre_category_id;

    @Column(name = "category_name", length = 300, nullable = false)
    private String category_name;

    public Integer getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Integer category_id) {
        this.category_id = category_id;
    }

    public int getPreCategoryId() {
        return pre_category_id;
    }

    public void setPreCategoryId(int pre_category_id) {
        this.pre_category_id = pre_category_id;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

}
