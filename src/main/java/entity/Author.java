package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany(mappedBy = "authorId")
    private Set<Book> book = new HashSet<Book>();

    @Column(name = "firstName", length = 25)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
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

    @Override
    public String toString() {
        return "Author{" +
                "book=" + book +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}