/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Database;

import busstation.Humans.Driver;
import java.util.ArrayList;

public class DriversDB {

     ArrayList<Driver> driversDB = new ArrayList<>();
     ArrayList<String> driversUsernames= new ArrayList<>();

    /**
     * Creates a new object of type Driver iff there is no conflict with other
     * elements in the database.
     *
     * @param username
     * @param password
     * @param name
     * @param age
     * @param address
     * @param working
     * @return Boolean
     */
    public boolean createAccount(String username, String password, String name, int age, String address, boolean working) {
        if (validateUsername(username)) {
            driversDB.add(new Driver(username, password, name, age, address, working));
            driversUsernames.add(username);
            return true;
        }
        return false;
    }

    /**
     * Checks if the given log-in info matched the ones in the database, and
     * returns the matched object of type Manager
     *
     * @param username
     * @param password
     * @return object of type Driver
     */
    public Driver authenticate(String username, String password) {

        for (int i = 0; i < driversDB.size(); i++) {

            if (driversDB.get(i).getUsername().equals(username) && driversDB.get(i).getPassword().equals(password)) {
                return driversDB.get(i);
            }
        }
        return null;
    }

    /**
     * Checks if the username exists or not to allow only one unique username in
     * the database.
     *
     * @param username
     * @return Boolean
     */
    public boolean validateUsername(String username) {
        for (int i = 0; i < driversDB.size(); i++) {
            if (driversDB.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Changes the password of the given object of type Driver.
     *
     * @param Driver
     * @param newPassword
     * @return Boolean
     */
    public boolean changePassword(Driver Driver, String newPassword) {
        Driver.setPassword(newPassword);
        return true;
    }

    public ArrayList<String> getDriversUsernames() {
        return driversUsernames;
    }

    public ArrayList<Driver> getDrivers(){
        
        return driversDB;


    }
}
