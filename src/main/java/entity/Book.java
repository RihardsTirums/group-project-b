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
    private Integer bookId;

    @Column(name= "bookTitle")
    private String bookTitle;

    @Column(name= "bookDescription", columnDefinition="TEXT")
    private String bookDescription;

    @ManyToOne
    @JoinColumn(name= "authorId")
    private  Author author;

    @Column(name="bookReleaseDate")
    private LocalDate bookReleaseDate;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


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


    public LocalDate getBookReleaseDate() {
        return bookReleaseDate;
    }

    public void setBookReleaseDate(LocalDate bookReleaseDate) {
        this.bookReleaseDate = bookReleaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", author=" + author +
                ", bookReleaseDate=" + bookReleaseDate +
                '}';
    }
}
