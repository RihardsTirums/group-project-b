package entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "bookId")
    private int bookId;

    @Column(name= "bookTitle")
    private String bookTitle;

    @Column(name= "bookDescription", columnDefinition="TEXT")
    private String bookDescription;

    @Column(name= "authorId")
    private int authorId;

    @Column(name="bookRelaseDate")
    private LocalDate bookRelaseDate;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public LocalDate getBookRelaseDate() {
        return bookRelaseDate;
    }

    public void setBookRelaseDate(LocalDate bookRelaseDate) {
        this.bookRelaseDate = bookRelaseDate;
    }
}
