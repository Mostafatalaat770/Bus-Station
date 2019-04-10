package busstation;

import busstation.Database.CustomersDB;
import busstation.Database.DriversDB;
import busstation.Database.ManagersDB;
import busstation.Database.TripsDB;
import busstation.Files.CustomersManagement;
import busstation.Humans.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    private static int humanTypeChooser;
   @FXML private Label customerNameLabel ;
    static CustomersDB customersDB = new CustomersDB();
    CustomersManagement customersManagement = new CustomersManagement(customersDB);
    ManagersDB managersDB = new ManagersDB();
    DriversDB driversDB = new DriversDB();
    TripsDB tripsDB = new TripsDB();
    Customer customer;
    // sign up paramerters==============================================================
    public TextField logInUserNameTextField=new TextField();
    public PasswordField logInPasswordTextField=new PasswordField();
    public TextField signUpFirstNameTextField=new TextField();
    public TextField signUpLastNameTextField=new TextField();
    public TextField signUpUsernameTextField=new TextField();
    public TextField signUpPasswordTextField=new TextField();
    public TextField signUpAgeTextField=new TextField();
    public ToggleButton signUpVIPToggleButton=new ToggleButton();
    //==================================================================================



    public void handleMangerButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=1;
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
          }
    public void handleDriverButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=2;
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
         }
    public void handleCustomerButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=3;
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    public void handleSignUpButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    public void handleSubmitSignUpButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("sample.fxml"));
        customersDB.createAccount(signUpUsernameTextField.getText(),signUpPasswordTextField.getText(),signUpFirstNameTextField.getText()+signUpLastNameTextField.getText(),Integer.parseInt(signUpAgeTextField.getText()),false,signUpVIPToggleButton.isSelected(),100);
        Scene Loginscene = new Scene(LoginScreen);
        customersManagement.writeFile();
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML private void handleSubmitLogInButton(ActionEvent event) throws IOException {
        switch (humanTypeChooser)
        {
            case 1:
                customer = customersDB.authenticate(logInUserNameTextField.getText(),logInPasswordTextField.getText());
                if(customer !=null){
                Parent LoginScreen= FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
                Scene Loginscene = new Scene(LoginScreen);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();}
                else
                    System.out.println("a7a");
                break;
            case 2:

            case 3:
                customersManagement.readFile();
                customer = customersDB.authenticate(logInUserNameTextField.getText(),logInPasswordTextField.getText());
                if(customer !=null){

                    Parent LoginScreen= FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
                    Scene Loginscene = new Scene(LoginScreen);
                    //System.out.println( customerNameLabel.getText());
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();
                }
                else
                    System.out.println("a7a");
                break;

        }
    }
    public void handleMangeMangerAccountButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("MangeAccount.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }

    }

