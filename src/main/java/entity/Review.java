package entity;

import javax.persistence.*;

@Entity
@Table(name= "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewsId")
    private Integer reviewsId;

    @Column(name = "bookId")
    private Integer bookId;

    @Column(name = "score")
    private Integer score;

    @Column(name = "review", columnDefinition = "TEXT")
    private String review;

    public Integer getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(Integer reviewsId) {
        this.reviewsId = reviewsId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewsId=" + reviewsId +
                ", bookId=" + bookId +
                ", score=" + score +
                ", review='" + review + '\'' +
                '}';
    }
}

