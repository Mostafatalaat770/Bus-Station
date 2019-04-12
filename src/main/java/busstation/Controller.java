package busstation;

import busstation.Database.CustomersDB;
import busstation.Database.DriversDB;
import busstation.Database.ManagersDB;
import busstation.Database.TripsDB;
import busstation.Files.CustomersManagement;
import busstation.Humans.Customer;
import busstation.Humans.Driver;
import busstation.Humans.Manager;
import busstation.Tickets.Tickets;
import busstation.Trips.Trips;
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
    //to choose between the 3 humans (driver, customer, manger)
    private static int humanTypeChooser;
    //handling database================================================================
    private static CustomersDB customersDB = new CustomersDB();
    private static ManagersDB managersDB = new ManagersDB();
    private static DriversDB driversDB = new DriversDB();
    private static  TripsDB tripsDB = new TripsDB();
    //=================================================================================
    /*

    */
    //refrence to the data base========================================================
    private static Manager manager;
    private static Customer customer;
    private static Driver driver;
    private  static Tickets tickets;
    private  static Trips trips;
    //=================================================================================
    /*

    */
    // sign up paramerters=============================================================
    @FXML private TextField logInUserNameTextField=new TextField();
    @FXML private PasswordField logInPasswordTextField=new PasswordField();
    @FXML private TextField signUpFirstNameTextField=new TextField();
    @FXML private TextField signUpLastNameTextField=new TextField();
    @FXML private TextField signUpUsernameTextField=new TextField();
    @FXML private TextField signUpPasswordTextField=new TextField();
    @FXML private TextField signUpAgeTextField=new TextField();
    @FXML private ToggleButton signUpVIPToggleButton=new ToggleButton();
    //=================================================================================
    /*

    */
    @FXML private Text errorText;//shows all the errors in authentications, sign up, etc..
    @FXML private Text VIPtext;//for the vip msge. :P
    /*

    */
    //at the sample page===============================================================
    @FXML private void handleMangerButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=1;
        managersDB.createAccount("admin","admin","swidan",20,"214 portsaid");
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
          }
    @FXML private void handleDriverButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=2;
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
         }
    @FXML private void handleCustomerButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=3;
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    //=================================================================================
    /*

    */
    //to open the sign up scene============================================================
    @FXML private void handleSignUpButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    //=====================================================================================
    /*

    */
    //to create a new customer==============================================================
    @FXML private void handleSubmitSignUpButtonClick(ActionEvent event) throws IOException {
        if(customersDB.createAccount(signUpUsernameTextField.getText(),signUpPasswordTextField.getText(),signUpFirstNameTextField.getText()+" "+signUpLastNameTextField.getText(),Integer.parseInt(signUpAgeTextField.getText()),false,signUpVIPToggleButton.isSelected(),100)!=null) {
            Parent LoginScreen = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene Loginscene = new Scene(LoginScreen);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Loginscene);
            window.show();
        }
        else {
            errorText.setText("username already used");
        }
    }
    //======================================================================================
    /*

    */
    //authentication for all humans=========================================================
    @FXML private void handleSubmitLogInButton(ActionEvent event) throws IOException {
        switch (humanTypeChooser)
        {
            case 1://manger
              manager= managersDB.authenticate(logInUserNameTextField.getText(),logInPasswordTextField.getText());
                if(manager !=null){
                Parent LoginScreen= FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
                Scene Loginscene = new Scene(LoginScreen);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();}
                else
                    errorText.setText("wrong username or password");
                break;
            case 2://driver
                driver = driversDB.authenticate(logInUserNameTextField.getText(),logInPasswordTextField.getText());
                if (driver!= null) {
                    Parent LoginScreen = FXMLLoader.load(getClass().getResource("DriverPage.fxml"));
                    Scene Loginscene = new Scene(LoginScreen);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();
                }
                else
                    errorText.setText("wrong username or password");
                break;
            case 3://customer
                customer = customersDB.authenticate(logInUserNameTextField.getText(),logInPasswordTextField.getText());
                if(customer !=null){

                   Parent LoginScreen= FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
                   Scene Loginscene = new Scene(LoginScreen);
                   Stage  window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();
                }
                else
                    errorText.setText("wrong username or password");
                break;

        }

    }
    //======================================================================================
    /*

     */
    //rewrites the files to save changes===================================================
    @FXML private void handleLogOutButton(ActionEvent event) throws IOException {
        switch (humanTypeChooser)
        {
            case 1:
                    Parent LoginScreen= FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Scene Loginscene = new Scene(LoginScreen);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();

                break;
            case 2:
                 LoginScreen= FXMLLoader.load(getClass().getResource("sample.fxml"));
                Loginscene = new Scene(LoginScreen);
                window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();
                break;
            case 3:

                    LoginScreen= FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Loginscene = new Scene(LoginScreen);
                    window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();

                break;

        }

    }
    //=====================================================================================
    /*

    */
    //shows the change password scene=======================================================
    @FXML private void handleChangePasswordButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    //======================================================================================
    /*

    */
    //opens the hiring scene================================================================
    @FXML private void handleAddDriverButtonClick(ActionEvent event) throws IOException {

        Parent LoginScreen= FXMLLoader.load(getClass().getResource("AddDriverPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    //======================================================================================
    /*

    */
    //hires a driver=======================================================================
    @FXML private void handleHireDriverButtonClick(ActionEvent event) throws IOException {
        if(driversDB.createAccount(signUpUsernameTextField.getText(),signUpPasswordTextField.getText(),signUpFirstNameTextField.getText(),Integer.parseInt(signUpAgeTextField.getText()),"in the bus station",signUpVIPToggleButton.isSelected())) {
            Parent LoginScreen = FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
            Scene Loginscene = new Scene(LoginScreen);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Loginscene);
            window.show();
        }
        else
            errorText.setText("username already used");

    }
    //=====================================================================================
    /*

    */
    //changes password for human===========================================================
    @FXML private void handleChangeButtonClick(ActionEvent event) throws IOException {
        switch (humanTypeChooser)
        {
            case 1://manger
               managersDB.changePassword(manager,signUpPasswordTextField.getText());
                    Parent LoginScreen= FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
                    Scene Loginscene = new Scene(LoginScreen);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();
                break;
            case 2://driver
                driversDB.changePassword(driver,signUpPasswordTextField.getText());
                    LoginScreen = FXMLLoader.load(getClass().getResource("DriverPage.fxml"));
                    Loginscene = new Scene(LoginScreen);
                    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();
                break;
            case 3://customer
               customersDB.changePassword(customer,signUpPasswordTextField.getText());
                    LoginScreen= FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
                    Loginscene = new Scene(LoginScreen);
                    window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();
                break;

        }

    }
    //=====================================================================================
    /*

    */
    //show create trip scene===============================================================
    @FXML private void handleCreateTripButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("CreateTripPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    //=====================================================================================

    //shows the vip msge===================================================================
    @FXML private void handleVIPButtonClick(){VIPtext.setText(
            "There is no reason to be a VIP member.\nIt's just a despirate atempt form us\n(the developers) to get a bonus mark.\nAlso you get a discount, but u already\nknow thats not real money. Oh well....");}
    //=====================================================================================

}

