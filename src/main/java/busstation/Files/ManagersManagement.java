/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.ManagersDB;
import busstation.Humans.Manager;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class ManagersManagement implements FileManagement {

    private Scanner in;
    private final ManagersDB managersDB;

    /**
     * Takes the object of the database of customers so we can do operations on
     * it.
     *
     * @param managersDB
     */
    public ManagersManagement(ManagersDB managersDB) {
        this.managersDB = managersDB;
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
            managersDB.getManagers().clear();
            in = new Scanner(new File("Managers.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String username = in.next();
                String password = in.next();
                String name = in.next();
                int age = Integer.parseInt(in.next());
                String address = in.next();
                managersDB.createAccount(username, password, name, age, address);
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
            Formatter file = new Formatter("Managers.txt");
            for (int i = 0; i < managersDB.getManagers().size(); i++) {
                Manager tempManager = managersDB.getManagers().get(i);
                String username = tempManager.getUsername();
                String password = tempManager.getPassword();
                String name = tempManager.getName();
                int age = tempManager.getAge();
                String address = tempManager.getAddress();
                if (i + 1 != managersDB.getManagers().size()) {
                    file.format("%s%s%s%s%s%n", username + (","), password + (","), name + (","), age + (","), address);
                } else {
                    file.format("%s%s%s%s%s", username + (","), password + (","), name + (","), age + (","), address);

                }

            }
            file.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }
    public static void main(String[] args){
        ManagersDB managersDB = new ManagersDB();
        ManagersManagement managersManagement =  new ManagersManagement(managersDB);
        managersDB.createAccount("admin1","admin1","admin",15,"asda");
        managersManagement.writeFile();
        Manager m = managersDB.authenticate("admin1","admin1");
        System.out.println(m.getName());
        managersManagement.readFile();
        m = managersDB.authenticate("admin","admin");
        System.out.println(m.getName());
    }
}
