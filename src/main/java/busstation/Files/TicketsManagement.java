/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.CustomersDB;
import busstation.Database.TripsDB;
import busstation.Humans.Customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class TicketsManagement {

    private Scanner in;

    public boolean readFile(Customer customer, CustomersDB customersDB, TripsDB tripsDB) {

        try {
            in = new Scanner(new File(customer.getUsername() + ".txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String name = in.next();
                String startTime = in.next();
                String endTime = in.next();
                String seatNumber = in.next();
                customersDB.addTicket(customer, tripsDB, name, startTime, endTime, seatNumber);
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;

    }

    public void writeFile(Customer customer) throws IOException {
        try {
            File f = new File(customer.getUsername() + ".txt");
            f.createNewFile();
            Formatter file = new Formatter(f);
            for (int i = 0; i < customer.getTicketsHistory().size(); i++) {
                String name = customer.getTicketsHistory().get(i).getName();
                String startTime = customer.getTicketsHistory().get(i).getStartTime();
                String endTime = customer.getTicketsHistory().get(i).getEndTime();
                String seatNumber = customer.getTicketsHistory().get(i).getSeatNumber();
                if (i + 1 != customer.getTicketsHistory().size()) {
                    file.format("%s%s%s%s%n", name + ",", startTime + ",", endTime + ",", seatNumber);
                } else {
                    file.format("%s%s%s%s", name + ",", startTime + ",", endTime + ",", seatNumber);

                }

            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        }
    }
}
