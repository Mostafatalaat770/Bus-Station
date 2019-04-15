package busstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MangerPageController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //opens the hiring scene================================================================
    @FXML
    private void handleAddDriverButtonClick(ActionEvent event) throws IOException {

        Parent LoginScreen= FXMLLoader.load(getClass().getResource("AddDriverPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    //======================================================================================
    /*

     */
}
