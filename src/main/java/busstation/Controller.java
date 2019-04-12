package busstation;
import busstation.Database.CustomersDB;
import busstation.Database.DriversDB;
import busstation.Database.ManagersDB;
import busstation.Database.TripsDB;
import busstation.Database.VehiclesDB;
import busstation.Files.CustomersManagement;
import busstation.Files.DriversManagement;
import busstation.Files.ManagersManagement;
import busstation.Files.TicketsManagement;
import busstation.Files.TripsManagement;
import busstation.Files.VehiclesManagement;
import busstation.Humans.Customer;
import busstation.Humans.Driver;
import busstation.Humans.Manager;
import busstation.Tickets.Tickets;
import busstation.Trips.Trips;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
public class Controller implements Initializable{
    
    //to choose between the 3 humans (driver, customer, manger)
    private static int humanTypeChooser;
    //handling database================================================================
    private static CustomersDB customersDB = new CustomersDB();
    private static ManagersDB managersDB = new ManagersDB();
    private static DriversDB driversDB = new DriversDB();
    private static TripsDB tripsDB = new TripsDB();
    private static VehiclesDB vehiclesDB = new VehiclesDB();
    private static CustomersManagement customersManagement = new CustomersManagement(customersDB);
    private static DriversManagement driversManagement = new DriversManagement(driversDB);
    private static ManagersManagement managersManagement = new ManagersManagement(managersDB);
    private static TripsManagement tripsManagement = new TripsManagement(tripsDB);
    private static VehiclesManagement vehiclesManagement = new VehiclesManagement(vehiclesDB);
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
    //handelimg trip creation==========================================================
    @FXML private TextField nameTextField=new TextField();
    @FXML private TextField startLocationTextField=new TextField();
    @FXML private TextField endLocationTextField=new TextField();
    @FXML private TextField startTimeTextField=new TextField();
    @FXML private TextField endTimeTextField=new TextField();
    @FXML private TextField priceTextField=new TextField();
    @FXML private TextField discountTextField=new TextField();
    @FXML private ToggleButton externalTripToggleButton=new ToggleButton();
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
    @FXML private TextField balanceTextField;//for adding balance
    @FXML private Text balanceText;//shows new balance
    /*

     */
    //all combo boxes==================================================================
    @FXML private ComboBox<String>  driversComboBox=new ComboBox<>();
    ObservableList<String > driversList= FXCollections.observableArrayList(driversDB.getDriversUsernames());
    @FXML private  ComboBox<String> tripTypeComboBox= new ComboBox<>();
    ObservableList<String > tripTypeList= FXCollections.observableArrayList("one stop trip","multi stop trip","no stop trip");
    @FXML private ComboBox<String> internalTripsComboBox=new ComboBox<>();
    @FXML private ComboBox<String> internalTripsComboBox2=new ComboBox<>();
    @FXML private ComboBox<String> internalTripsComboBox3=new ComboBox<>();
    ObservableList<String > internalTripsList= FXCollections.observableArrayList(tripsDB.getInternalTripsName());
    @FXML private ComboBox<String> externalTripsComboBox=new ComboBox<>();
    @FXML private ComboBox<String> externalTripsComboBox2=new ComboBox<>();
    @FXML private ComboBox<String> externalTripsComboBox3=new ComboBox<>();
    ObservableList<String > externalTripsList= FXCollections.observableArrayList(tripsDB.getExternalTripsName());
    //=================================================================================
    /*

     */
    //for the trip's info==============================================================
    @FXML private Text tripNameTextField=new Text();
    @FXML private Text tripDestinationTextField=new Text();
    @FXML private Text tripPriceTextField=new Text();
    @FXML private Text tripDiscountTextField=new Text();
    @FXML private Text tripNameTextField2=new Text();
    @FXML private Text tripDestinationTextField2=new Text();
    @FXML private Text tripPriceTextField2=new Text();
    @FXML private Text tripDiscountTextField2=new Text();
    //================================================================================

    /*

     */
    //for the combpbpxes to be filled==================================================
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    driversComboBox.setItems(driversList);
    tripTypeComboBox.setItems(tripTypeList);
    internalTripsComboBox.setItems(internalTripsList);
    internalTripsComboBox2.setItems(internalTripsList);
    internalTripsComboBox3.setItems(internalTripsList);
        externalTripsComboBox2.setItems(externalTripsList);
        externalTripsComboBox3.setItems(externalTripsList);
    externalTripsComboBox.setItems(externalTripsList);
    }
    //==================================================================================
//    tripsManagement.writeExternalFile();
//        tripsManagement.writeInternalFile();
//        managersManagement.writeFile();
//        driversManagement.writeFile();
//        try {
//        customersManagement.writeFile();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }



    //at the sample page===============================================================
    @FXML private void handleMangerButtonClick(ActionEvent event) throws IOException {

        humanTypeChooser=1;
        tripsManagement.readInternalFile();
        tripsManagement.readExternalFile();
        managersManagement.readFile();
        driversManagement.readFile();
        customersManagement.readFile(tripsDB);
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
          }
    @FXML private void handleDriverButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=2;
        tripsManagement.readInternalFile();
        tripsManagement.readExternalFile();
        managersManagement.readFile();
        driversManagement.readFile();
        customersManagement.readFile(tripsDB);
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
         }
    @FXML private void handleCustomerButtonClick(ActionEvent event) throws IOException {
        humanTypeChooser=3;
        tripsManagement.readInternalFile();
        tripsManagement.readExternalFile();
        managersManagement.readFile();
        driversManagement.readFile();
        customersManagement.readFile(tripsDB);
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

        if(customersDB.createAccount(signUpUsernameTextField.getText(),signUpPasswordTextField.getText(),signUpFirstNameTextField.getText()+" "+signUpLastNameTextField.getText(),Integer.parseInt(signUpAgeTextField.getText()),false,signUpVIPToggleButton.isSelected(),"100")!=null) {
                    try {
        customersManagement.writeFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
            Parent LoginScreen = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene Loginscene = new Scene(LoginScreen);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Loginscene);
            window.show();
        }
        else {
            errorText.setText("Username already exists!");
        }
    }
    //======================================================================================
    /*

    */
    //authentication for all humans=========================================================
    @FXML private void handleSubmitLogInButton(ActionEvent event) throws IOException {
        switch (humanTypeChooser)
        {
            case 1://manager
                manager= managersDB.authenticate(logInUserNameTextField.getText(),logInPasswordTextField.getText());
                if(manager !=null){
                Parent LoginScreen= FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
                Scene Loginscene = new Scene(LoginScreen);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();}
                else {
                    errorText.setText("Wrong username or password!");
        }
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
                    errorText.setText("Wrong username or password!");
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
                    errorText.setText("Wrong username or password!");
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
                    managersManagement.writeFile();
                    Parent LoginScreen= FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Scene Loginscene = new Scene(LoginScreen);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(Loginscene);
                    window.show();

                break;
            case 2:
                driversManagement.writeFile();
                LoginScreen= FXMLLoader.load(getClass().getResource("sample.fxml"));
                Loginscene = new Scene(LoginScreen);
                window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();
                break;
            case 3:
                    customersManagement.writeFile();
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
        if(driversDB.createAccount(signUpUsernameTextField.getText(),signUpPasswordTextField.getText(),signUpFirstNameTextField.getText(),"in the bus station")) {

        driversManagement.writeFile();
            Parent LoginScreen = FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
            Scene Loginscene = new Scene(LoginScreen);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Loginscene);
            window.show();
        }
        else {
            errorText.setText("Username already exists!");
        }

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
    /*

    */
    //shows the vip msge===================================================================
    @FXML private void handleVIPButtonClick(){VIPtext.setText(
            "There is no reason to be a VIP member.\nIt's just a despirate atempt form us\n(the developers) to get a bonus mark.\nAlso you get a discount, but u already\nknow thats not real money. Oh well....");}
    //=====================================================================================
    /*

    */
    //creates a new trip===================================================================
    @FXML private void handlesaveTripButtonClick(ActionEvent event)throws IOException  {
        if(externalTripToggleButton.isSelected()){
            tripsDB.createExternalTrip(nameTextField.getText(),startLocationTextField.getText(),endLocationTextField.getText(),startTimeTextField.getText(),endTimeTextField.getText(),priceTextField.getText(),discountTextField.getText(),tripTypeComboBox.getValue());
        tripsManagement.writeExternalFile();
        }
        else {
            tripsDB.createInternalTrip(nameTextField.getText(), startLocationTextField.getText(), endLocationTextField.getText(), startTimeTextField.getText(), endTimeTextField.getText(), priceTextField.getText(), discountTextField.getText(), tripTypeComboBox.getValue());
            tripsManagement.writeInternalFile();
        }

        Parent LoginScreen= FXMLLoader.load(getClass().getResource("MangerPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();

    }
    //=====================================================================================
    /*

    */
    //shows trip  for Manger 1===============================================================
    @FXML private void handleShowTripMangerButtonClick2(){
        int i;
        for(i=0;i<tripsDB.getExternalTrips().size();i++)
        {
            if(externalTripsComboBox3.getValue().equals(tripsDB.getExternalTrips().get(i).getName()))
                break;
        }
        tripNameTextField2.setText("Name: "+tripsDB.getExternalTrips().get(i).getName());
        tripDestinationTextField2.setText("Destination: "+tripsDB.getExternalTrips().get(i).getEndPos());
        tripPriceTextField2.setText("Price: "+tripsDB.getExternalTrips().get(i).getPrice());
        tripDiscountTextField2.setText("Discount: "+tripsDB.getExternalTrips().get(i).getDiscountPrecent());

    }
    //=======================================================================================
    /*

    */
    //show trips for manager 2===============================================================
    @FXML private void handleShowTripMangerButtonClick() {
        int i;
        for (i = 0; i < tripsDB.getInternalTrips().size(); i++) {
            if (internalTripsComboBox3.getValue().equals(tripsDB.getInternalTrips().get(i).getName()))
                break;
        }
        tripNameTextField.setText("Name: " + tripsDB.getInternalTrips().get(i).getName());
        tripDestinationTextField.setText("Destination: " + tripsDB.getInternalTrips().get(i).getEndPos());
        tripPriceTextField.setText("Price: " + tripsDB.getInternalTrips().get(i).getPrice());
        tripDiscountTextField.setText("Discount: " + tripsDB.getInternalTrips().get(i).getDiscountPrecent());
    }
    //=======================================================================================
    /*

     */
    //assign driver to an internal trip==============================================================
    @FXML private void handleAssignDriverButtonClick(){
        int i; int j;
        for(i=0;i<driversDB.getDrivers().size();i++)
            if(driversComboBox.getValue().equals(driversDB.getDrivers().get(i).getUsername()))
                break;
         for(j=0;j<tripsDB.getInternalTrips().size(); j++)
             if (internalTripsComboBox.getValue().equals(tripsDB.getInternalTrips().get(j).getName()))
                 break;
             tripsDB.getInternalTrips().get(j).setEndTime(driversDB.getDrivers().get(i).getName());

             tripsManagement.writeInternalFile();

    }
    //==============================================================================================
    /*

     */
    //assign driver to an external trip=============================================================
    @FXML private void handleAssignDriverButtonClick1(){
        int i; int j;
        for(i=0;i<driversDB.getDrivers().size();i++)
            if(driversComboBox.getValue().equals(driversDB.getDrivers().get(i).getUsername()))
                break;
        for(j=0;j<tripsDB.getExternalTrips().size(); j++)
            if (externalTripsComboBox.getValue().equals(tripsDB.getExternalTrips().get(j).getName()))
                break;
        tripsDB.getInternalTrips().get(j).setEndTime(driversDB.getDrivers().get(i).getName());
        tripsManagement.writeExternalFile();

    }
    //==============================================================================================
    /*

    */
    //delete an internal trip========================================================================
    @FXML private void handleDeleteTripMangerButtonClick() {
        int i;
        for (i = 0; i < tripsDB.getInternalTrips().size(); i++) {
            if (internalTripsComboBox2.getValue().equals(tripsDB.getInternalTrips().get(i).getName()))
                break;
        }
        manager.removeTrip(tripsDB.getInternalTrips().get(i),tripsDB,customersDB);
        tripsManagement.writeExternalFile();
        tripsManagement.writeInternalFile();

    }
    //================================================================================================
    /*

    */
    //deletes external trips==========================================================================
    @FXML private void handleDeleteTripMangerButtonClick2() {
        int i;
        for (i = 0; i < tripsDB.getExternalTrips().size(); i++) {
            if (externalTripsComboBox2.getValue().equals(tripsDB.getExternalTrips().get(i).getName()))
                break;
        }
        manager.removeTrip(tripsDB.getExternalTrips().get(i),tripsDB,customersDB);
        tripsManagement.writeExternalFile();
        tripsManagement.writeInternalFile();

    }
    //================================================================================================
    /*

    */
    //add balance to customer=========================================================================
    @FXML private void handleAddBalanceButtonClick(){
        customer.setBalance(Double.toString(Double.parseDouble(customer.getBalance())+Double.parseDouble(balanceTextField.getText())));
        balanceText.setText(balanceTextField.getText()+" was added to the balance. Balance is now "+customer.getBalance());

    }

    }

