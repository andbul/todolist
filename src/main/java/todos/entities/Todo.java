package todos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by andrey on 10.11.15.
 */
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    private String text;
    @Column(nullable = false)
    private Boolean closed = false;

    @JsonIgnore
    @ManyToOne
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
