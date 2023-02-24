package erp.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name="a_nswer")
public class Answer {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private String answername;
    private String postedBy;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAnswername() {
        return answername;
    }
    public void setAnswername(String answername) {
        this.answername = answername;
    }
    public String getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}