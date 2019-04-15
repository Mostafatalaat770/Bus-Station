/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Database;

import busstation.Humans.Manager;
import java.util.ArrayList;

public class ManagersDB {

    ArrayList<Manager> managersDB = new ArrayList<>();

    /**
     * Creates a new object of type Manager iff there is no conflict with other
     * elements in the database.
     *
     * @param username
     * @param password
     * @param name
     * @param age
     * @param address
     * @return Boolean
     */
    public boolean createAccount(String username, String password, String name, int age, String address) {
        if (validateUsername(username)) {
            managersDB.add(new Manager(username, password, name, age, address));
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
     * @return object of type Manager
     */
    public Manager authenticate(String username, String password) {

        for (int i = 0; i < managersDB.size(); i++) {

            if (managersDB.get(i).getUsername().equals(username) && managersDB.get(i).getPassword().equals(password)) {
                return managersDB.get(i);
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
        for (int i = 0; i < managersDB.size(); i++) {
            if (managersDB.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Changes the password of the given object of type Manager.
     *
     * @param manager
     * @param newPassword
     * @return Boolean
     */
    public boolean changePassword(Manager manager, String newPassword) {
        manager.setPassword(newPassword);
        return true;
    }
      public ArrayList<Manager> getManagers(){
        
        return managersDB;
    }
}
