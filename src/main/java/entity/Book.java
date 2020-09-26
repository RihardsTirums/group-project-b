package entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "bookId")
    private Integer id;

    @Column(name = "bookTitle", length = 25)
    private String firstName;

    @Column(name = "bookDescription", length = 250)
    private String lastName;

    @Column(name = "authorId")
    private Integer id2;

    @Column(name = "bookReleaseDate")
    private LocalDate bookReleaseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    public LocalDate getBookReleaseDate() {
        return bookReleaseDate;
    }

    public void setBookReleaseDate(LocalDate bookReleaseDate) {
        this.bookReleaseDate = bookReleaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id2=" + id2 +
                ", bookReleaseDate=" + bookReleaseDate +
                '}';
    }


}
