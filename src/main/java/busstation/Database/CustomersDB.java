/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Database;

import busstation.Humans.Customer;
import busstation.Tickets.Tickets;
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
    public Customer createAccount(String username, String password, String name, int age, boolean specialNeeds, boolean VIP, String balance) {
        if (validateUsername(username)) {
            customerDB.add(new Customer(username, password, name, age, specialNeeds, VIP, balance));
            return customerDB.get(customerDB.size() - 1);
        }
        return null;
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
     * In order to access the database we have to send it's reference(object) to
     * get its methods, so by returning its object, we get what we wanted.
     *
     * @return the database of customers
     */
    public ArrayList<Customer> getCustomers() {

        return customerDB;
    }

    public void addTicket(Customer customer, TripsDB tripsDB, String name, String  startTime, String endTime, String seatNumber) {
        for (int i = 0; i < tripsDB.getExternalTrips().size(); i++) {
            String name1 = tripsDB.getExternalTrips().get(i).getName();
            String startTime1 = tripsDB.getExternalTrips().get(i).getStartTime();
            String endTime1 = tripsDB.getExternalTrips().get(i).getEndTime();
            if (name.equals(name1) && (startTime == startTime1) && (endTime == endTime1)) {
                String startPos = tripsDB.getExternalTrips().get(i).getStartPos();
                String endPos = tripsDB.getExternalTrips().get(i).getEndPos();
                String price = tripsDB.getExternalTrips().get(i).getPrice();
                String discountPrecent = tripsDB.getExternalTrips().get(i).getDiscountPrecent();
                String stopType = tripsDB.getExternalTrips().get(i).getStopType();
                customer.getTicketsHistory().add(new Tickets(name, startPos, endPos, startTime, endTime, price, discountPrecent, stopType, seatNumber));
                return;
            }
        }
        for (int i = 0; i < tripsDB.getInternalTrips().size(); i++) {
            String name1 = tripsDB.getInternalTrips().get(i).getName();
            String startTime1 = tripsDB.getInternalTrips().get(i).getStartTime();
            String endTime1 = tripsDB.getInternalTrips().get(i).getEndTime();
            if (name.equals(name1) && (startTime == startTime1) && (endTime == endTime1)) {
                String startPos = tripsDB.getInternalTrips().get(i).getStartPos();
                String endPos = tripsDB.getInternalTrips().get(i).getEndPos();
                String price = tripsDB.getInternalTrips().get(i).getPrice();
                String discountPrecent = tripsDB.getInternalTrips().get(i).getDiscountPrecent();
                String stopType = tripsDB.getInternalTrips().get(i).getStopType();
                customerDB.get(getCustomers().size() - 1).getTicketsHistory().add(new Tickets(name, startPos, endPos, startTime, endTime, price, discountPrecent, stopType, seatNumber));
                return;
            }
        }
    }
}
