package entity;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table (name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "authorId")
    private int authorId;

    @Column(name = "firstName", length = 25)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}