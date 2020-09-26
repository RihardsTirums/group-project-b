package entity;

import javax.persistence.*;

@Entity
@Table(name= "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewsId")
    private int reviewsId;

    @Column(name="bookId")
    private int bookId;

    @Column(name="score")
    private int score;

    @Column(name= "review", columnDefinition = "TEXT")
    private String review;

    public int getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(int reviewsId) {
        this.reviewsId = reviewsId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

