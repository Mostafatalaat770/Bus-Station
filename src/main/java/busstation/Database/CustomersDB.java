/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Database;

import busstation.Humans.Customer;
import java.util.ArrayList;

public class CustomersDB {

    ArrayList<Customer> customerDB = new ArrayList<>();

    /**
     * Creates a new object of type Customer iff there is no conflict with other
     * elements in the database.
     *
     * @param username
     * @param password
     * @param name
     * @param age
     * @param specialNeeds
     * @param VIP
     * @param balance
     * @return Boolean
     */
    public boolean createAccount(String username, String password, String name, int age, boolean specialNeeds, boolean VIP, double balance) {
        if (validateUsername(username)) {
            customerDB.add(new Customer(username, password, name, age, specialNeeds, VIP, balance));
            return true;
        }
        return false;
    }

    /**
     * Checks if the given log-in info matched the ones in the database, and
     * returns the matched object of type Customer
     *
     * @param username
     * @param password
     * @return object of type Customer
     */
    public Customer authenticate(String username, String password) {

        for (int i = 0; i < customerDB.size(); i++) {

            if (customerDB.get(i).getUsername().equals(username) && customerDB.get(i).getPassword().equals(password)) {
                return customerDB.get(i);
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
        for (int i = 0; i < customerDB.size(); i++) {
            if (customerDB.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Changes the password of the given object of type Customer.
     *
     * @param customer
     * @param newPassword
     * @return Boolean
     */
    public boolean changePassword(Customer customer, String newPassword) {
        customer.setPassword(newPassword);
        return true;
    }
    
    /**
     * In order to access the database we have to send it's reference(object) to get its
     * methods, so by returning its object, we get what we wanted.
     * @return the database of customers
     */
    public ArrayList<Customer> getCustomers(){
        
        return customerDB;
    }

}
