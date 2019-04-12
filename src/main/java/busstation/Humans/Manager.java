/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Humans;

import busstation.Database.CustomersDB;
import busstation.Database.TripsDB;
import busstation.Trips.ExternalTrip;
import busstation.Trips.InternalTrip;

public class Manager extends Employees {

    public Manager(String username, String password, String name, int age, String address) {
        super(username, password, name, age, address);
    }

    public void removeTrip(InternalTrip trip, TripsDB tripsDB, CustomersDB customerDB) {
        tripsDB.getInternalTrips().remove(trip);
        for (int i = 0; i < customerDB.getCustomers().size(); i++) {
            String name = trip.getName();
            String startTime = trip.getStartTime();
            String endTime = trip.getEndTime();
            String name1 = customerDB.getCustomers().get(i).ticketsHistory.get(i).getName();
            String startTime1 = customerDB.getCustomers().get(i).ticketsHistory.get(i).getStartTime();
            String endTime1 = customerDB.getCustomers().get(i).ticketsHistory.get(i).getEndTime();

            if (name.equals(name1) && (startTime == startTime1) && (endTime == endTime1)) {
                customerDB.getCustomers().get(i).ticketsHistory.remove(i);
            }
        }
    }

    public void removeTrip(ExternalTrip trip, TripsDB tripsDB, CustomersDB customerDB) {
        tripsDB.getExternalTrips().remove(trip);
        for (int i = 0; i < customerDB.getCustomers().size(); i++) {
            String name = trip.getName();
            String startTime = trip.getStartTime();
            String endTime = trip.getEndTime();
            String name1 = customerDB.getCustomers().get(i).ticketsHistory.get(i).getName();
            String startTime1 = customerDB.getCustomers().get(i).ticketsHistory.get(i).getStartTime();
            String endTime1 = customerDB.getCustomers().get(i).ticketsHistory.get(i).getEndTime();

            if (name.equals(name1) && (startTime == startTime1) && (endTime == endTime1)) {
                customerDB.getCustomers().get(i).ticketsHistory.remove(i);
            }
        }
    }

}
