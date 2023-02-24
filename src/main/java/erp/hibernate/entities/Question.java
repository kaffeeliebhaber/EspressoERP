package erp.hibernate.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="q_uestion")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String qname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid")
    @OrderColumn(name = "type")
    private List<Answer> answers;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getQname() {
        return qname;
    }
    public void setQname(String qname) {
        this.qname = qname;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
