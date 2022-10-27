import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class onClick {
    @FXML
    private TextField tfTitle;

    @FXML
    void btnHOMEClicked(ActionEvent event) {
        // Stage window = (Stage) tfTitle.getScene().getWindow();
        System.out.println("hello worlddd");
    }
}
