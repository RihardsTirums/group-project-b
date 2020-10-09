package library.domain.review.add;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import library.domain.author.Author;
import library.domain.author.AuthorRepository;
import library.domain.book.Book;
import library.domain.book.BookRepository;
import library.domain.review.Review;

import java.net.URL;
import java.util.ResourceBundle;

    public class ReviewAddController implements Initializable {

        private final AuthorRepository authorRepository = new AuthorRepository();
        private final BookRepository bookRepository = new BookRepository();

        @FXML
        private JFXTextField title;
        @FXML
        private JFXTextField description;
        @FXML
        private JFXTextField authorId;

        @FXML
        private StackPane rootPane;

        private Review editable;

        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }

        public void setEditable(Review review) {
            this.editable = review;

        }

        @FXML
        private void addReview(ActionEvent event) {
            String bookTitle = title.getText();
            String bookDescription = description.getText();
            String bookAuthorId = authorId.getText();

            if (bookTitle.isEmpty() || bookDescription.isEmpty() || bookAuthorId.isEmpty()) {
                //TODO show user alert that all fields have to be filled
                return;
            }

            Long authorId = Long.parseLong(bookAuthorId);
            Author author = authorRepository.findOne(authorId);
            if (author == null) {
                //TODO author with such ID doesn't exist, display error to user!
                return;
            }

            if (editable == null) {
                bookRepository.save(new Book(bookTitle, bookDescription, author));
            } else {
                Book book = bookRepository.findOne(editable.getId());
                book.setTitle(bookTitle);
                book.setDescription(bookDescription);
                book.setAuthor(author);
                bookRepository.update(book);
            }
            clearEntries();
            closeStage();
        }

        @FXML
        private void cancel(ActionEvent event) {
            closeStage();
        }

        private void clearEntries() {
            editable = null;
            title.clear();
            description.clear();
            authorId.clear();
        }

        private void closeStage() {
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
        }
    }

