/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.DriversDB;
import busstation.Humans.Driver;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class DriversManagement implements FileManagement {

    private Scanner in;
    private final DriversDB driversDB;

    /**
     * Takes the object of the database of customers so we can do operations on
     * it.
     *
     * @param driversDB
     */
    public DriversManagement(DriversDB driversDB) {
        this.driversDB = driversDB;
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
            driversDB.getDrivers().clear();
            in = new Scanner(new File("Drivers.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String username = in.next();
                String password = in.next();
                String name = in.next();
                int age = Integer.parseInt(in.next());
                String address = in.next();
                boolean working = in.nextBoolean();
                driversDB.createAccount(username, password, name, age, address, working);
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
            Formatter file = new Formatter("Drivers.txt");
            for (int i = 0; i < driversDB.getDrivers().size(); i++) {
                Driver tempDriver = driversDB.getDrivers().get(i);
                String username = tempDriver.getUsername();
                String password = tempDriver.getPassword();
                String name = tempDriver.getName();
                int age = tempDriver.getAge();
                String address = tempDriver.getAddress();
                boolean working = tempDriver.isWorking();
                if (i + 1 != driversDB.getDrivers().size()) {
                    file.format("%s%s%s%s%s%s%n", username + (","), password + (","), name + (","), age + (","), address + (","), working );
                } else {
                    file.format("%s%s%s%s%s%s", username + (","), password + (","), name + (","), age + (","), address + (","), working );

                }

            }
            file.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }
}
