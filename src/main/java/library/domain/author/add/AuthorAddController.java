package library.domain.author.add;

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

import java.net.URL;
import java.util.ResourceBundle;

public class AuthorAddController implements Initializable {

    private final AuthorRepository authorRepository = new AuthorRepository();

    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;

    @FXML
    private StackPane rootPane;


    private Author editable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setEditable(Author author) {
        this.editable = author;
    }

    @FXML
    private void addAuthor(ActionEvent event) {
        String authorFirstName = firstName.getText();
        String authorLastName = lastName.getText();


        if (authorFirstName.isEmpty() || authorLastName.isEmpty()) {
            //TODO show user alert that all fields have to be filled
            return;
        }
        if (editable == null) {
            authorRepository.save(new Author(authorFirstName, authorLastName));
        } else {
            Author author = authorRepository.findOne(editable.getId());
            author.setFirstName(authorFirstName);
            author.setLastName(authorLastName);
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
        firstName.clear();
        lastName.clear();

    }

    private void closeStage() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}

