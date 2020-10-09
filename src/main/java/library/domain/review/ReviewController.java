package library.domain.review;

import com.sun.jmx.mbeanserver.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.domain.review.add.ReviewAddController;
import library.view.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviewController implements Initializable {

    private final ReviewRepository reviewRepository = new ReviewRepository();

    @FXML private TableView<Review> table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
        populateTable();
    }

    @FXML
    private void addReview(ActionEvent event) {
        ViewLoader.load(getClass().getResource("/ui/book/add_book.fxml"), "Add review");
    }

    @FXML
    private void editReview(ActionEvent event) {
        Review review = table.getSelectionModel().getSelectedItem();
        if (review == null) {
            return;
        }
        ReviewAddController controller = (ReviewAddController) ViewLoader.load(getClass()
                .getResource("/ui/book/add_book.fxml"), "Edit review");
        controller.setEditable(review);
    }

    @FXML
    private void deleteReview(ActionEvent event) {
        Review review = table.getSelectionModel().getSelectedItem();
        if (review == null) {
            return;
        }
        reviewRepository.delete(review);
        populateTable();
    }

    private void configureTable() {
        TableColumn<Review, Long> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Review, String> column2 = new TableColumn<>("Title");
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Review, String> column3 = new TableColumn<>("Description");
        column3.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Review, String> column4 = new TableColumn<>("Author");
        column4.setCellValueFactory(new PropertyValueFactory<>("authorFullName"));

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
    }

    private void populateTable() {
        ObservableList<Review> list = FXCollections.observableArrayList();
        list.addAll(reviewRepository.findAll());
        table.setItems(list);
    }
}


