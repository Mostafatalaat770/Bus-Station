/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.CustomersDB;
import busstation.Database.TripsDB;
import busstation.Humans.Customer;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class CustomersManagement {

    private Scanner in;
    private final CustomersDB customersDB;

    /**
     * Takes the object of the database of customers so we can do operations on
     * it.
     *
     * @param customersDB
     */
    public CustomersManagement(CustomersDB customersDB) {
        this.customersDB = customersDB;
    }

    /**
     * Read method which reads a predefined file and splits it in-order to get
     * our parameters from it.The parameters are comma separated.
     *
     * @param tripsDB
     * @return Boolean
     */
    public boolean readFile(TripsDB tripsDB) {
        try {
            in = new Scanner(new File("Customers.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                int i = 0;
                String username = in.next();
                String password = in.next();
                String name = in.next();
                int age = Integer.parseInt(in.next());
                boolean specialNeeds = Boolean.parseBoolean(in.next());
                boolean VIP = Boolean.parseBoolean(in.next());
                double balance = Double.parseDouble(in.next());
                customersDB.createAccount(username, password, name, age, specialNeeds, VIP, balance);
                if (in.hasNext("*")) {
                    String tickets = in.nextLine();
                    String[] ticketsInfo = tickets.split(",");
                    while (i < tickets.length()) {
                        String ticketName = ticketsInfo[i++];
                        double ticketStartTime = Double.parseDouble(ticketsInfo[i++]);
                        double ticketEndTime = Double.parseDouble(ticketsInfo[i++]);
                        int ticketSeatNumber = Integer.parseInt(ticketsInfo[i++]);
                        customersDB.addTicket(tripsDB, name, ticketStartTime, ticketEndTime, ticketSeatNumber);
                    }
                }
            }
            in.close();
            System.out.println("read file.\n");
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Can't read file.\n");
            return false;
        }

    }

    /**
     * Write method which saves the database of customers in a predefined file
     * or creates one if it isn't created. It saves the attributes of the class
     * comma separated.
     *
     * @return Boolean
     */
    public boolean writeFile() {
        try {
            Formatter file = new Formatter("Customers.txt");
            for (int i = 0; i < customersDB.getCustomers().size(); i++) {
                Customer tempCustomer = customersDB.getCustomers().get(i);
                String username = tempCustomer.getUsername();
                String password = tempCustomer.getPassword();
                String name = tempCustomer.getName();
                int age = tempCustomer.getAge();
                boolean specialNeeds = tempCustomer.isSpecialNeeds();
                boolean VIP = tempCustomer.isVIP();
                double balance = tempCustomer.getBalance();

                if (i + 1 != customersDB.getCustomers().size()) {
                    file.format("%s%s%s%s%s%s%s", username + (","), password + (","), name + (","), age + (","), specialNeeds + (","), VIP + (","), balance);
                    if (tempCustomer.getTicketsHistory().size() > 0) {
                        for (int y = 0; y < tempCustomer.getTicketsHistory().size(); y++) {
                            String ticketName = tempCustomer.getTicketsHistory().get(y).getName();
                            double ticketStartTime = tempCustomer.getTicketsHistory().get(y).getStartTime();
                            double ticketEndTime = tempCustomer.getTicketsHistory().get(y).getEndTime();
                            int ticketSeatNumber = tempCustomer.getTicketsHistory().get(y).getSeatNumber();
                            file.format("%s%s%s%s", ticketName + ",", ticketStartTime + ",", ticketEndTime + ",", ticketSeatNumber);
                        }
                    }
                    file.format("%n");
                } else {
                    file.format("%s%s%s%s%s%s%s", username + (","), password + (","), name + (","), age + (","), specialNeeds + (","), VIP + (","), balance);
                    if (tempCustomer.getTicketsHistory().size() > 0) {
                        for (int y = 0; y < tempCustomer.getTicketsHistory().size(); y++) {
                            String ticketName = tempCustomer.getTicketsHistory().get(y).getName();
                            double ticketStartTime = tempCustomer.getTicketsHistory().get(y).getStartTime();
                            double ticketEndTime = tempCustomer.getTicketsHistory().get(y).getEndTime();
                            int ticketSeatNumber = tempCustomer.getTicketsHistory().get(y).getSeatNumber();
                            file.format("%s%s%s%s", ticketName + ",", ticketStartTime + ",", ticketEndTime + ",", ticketSeatNumber);
                        }
                    }

                }
            }
            file.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }
}
