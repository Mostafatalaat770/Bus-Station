/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.CustomersDB;
import busstation.Humans.Customer;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class CustomersManagement implements FileManagement {

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
     * our parameters from it. The parameters are comma separated.
     *
     * @return Boolean
     */
    @Override
    public boolean readFile() {
        try {
            in = new Scanner(new File("Customers.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String username = in.next();
                String password = in.next();
                String name = in.next();
                int age = Integer.parseInt(in.next());
                boolean specialNeeds = Boolean.parseBoolean(in.next());
                boolean VIP = Boolean.parseBoolean(in.next());
                double balance = Double.parseDouble(in.next());
                customersDB.createAccount(username, password, name, age, specialNeeds, VIP, balance);
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
    @Override
    public boolean writeFile() {
        try {
            Formatter file = new Formatter("Customers.txt");
            customersDB.getCustomers();
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

    public static void main(String[] args) {
        CustomersDB customersDB = new CustomersDB();
        CustomersManagement customersManagement = new CustomersManagement(customersDB);
        customersManagement.readFile();
        customersDB.createAccount("Mostafa", "Swidan", "Ahmed Swidan", 20, true, true, 10);
        Customer test;
        customersDB.createAccount("Ahmed", "Swidan", "24 wink wink, love you <3", 24, true, true, 10);
        customersManagement.writeFile();
        test = customersDB.authenticate("Ahmed", "Swidan");
        System.out.println(test.getName());
    }
}
