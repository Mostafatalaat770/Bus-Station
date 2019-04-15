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

    private final CustomersDB customersDB;
    private final TicketsManagement ticketsManagement = new TicketsManagement();

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
     * Read method which reads a predefined file and splits it
     * inputScanner-order to get our parameters from it.The parameters are comma
     * separated.
     *
     * @param tripsDB
     * @return Boolean
     */
    public boolean readFile(TripsDB tripsDB) {
        try {
            customersDB.getCustomers().clear();
            Scanner inputScanner1 = new Scanner(new File("Customers.txt"));
            inputScanner1.useDelimiter(",|\\n");
            while (inputScanner1.hasNextLine()) {

                String username = inputScanner1.next();
                String password = inputScanner1.next();
                String name = inputScanner1.next();
                int age = Integer.parseInt(inputScanner1.next());
                boolean specialNeeds = Boolean.parseBoolean(inputScanner1.next());
                boolean VIP = Boolean.parseBoolean(inputScanner1.next());
                String balance = (inputScanner1.next());
                Customer temp = customersDB.createAccount(username, password, name, age, specialNeeds, VIP, balance);
                ticketsManagement.readFile(temp, customersDB, tripsDB);
            }

            System.out.println("read file.\n");
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Can't read file.\n");
            return false;
        }

    }

    /**
     * Write method which saves the database of customers in a predefined file
     * or creates one if it isn't created.It saves the attributes of the class
     * comma separated.
     *
     * @return Boolean
     * @throws java.io.IOException
     */
    public boolean writeFile() throws IOException {
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
                String balance = tempCustomer.getBalance();
                if (tempCustomer.getTicketsHistory().size() > 0) {
                    ticketsManagement.writeFile(tempCustomer);
                }
                if (i + 1 != customersDB.getCustomers().size()) {
                    file.format("%s%s%s%s%s%s%s%n", username + (","), password + (","), name + (","), age + (","), specialNeeds + (","), VIP + (","), balance);

                } else {
                    file.format("%s%s%s%s%s%s%s", username + (","), password + (","), name + (","), age + (","), specialNeeds + (","), VIP + (","), balance);
                }

            }

            file.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }
    public static void main(String[] args) throws IOException {
        CustomersDB customersDB1 = new CustomersDB();
        TripsDB tripsDB = new TripsDB();
        CustomersManagement customersManagement = new CustomersManagement(customersDB1);
        customersDB1.createAccount("1", "2", "3", 0, true, true, "0");
        Customer c = customersDB1.authenticate("1", "2");
        System.out.println(c.getName());
        customersManagement.writeFile();
        customersManagement.readFile(tripsDB);
        c = customersDB1.authenticate("1", "2");
        System.out.println(c.getName());
    }
    }

