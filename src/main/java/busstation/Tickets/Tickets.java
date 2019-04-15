/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Tickets;

import busstation.Trips.Trips;

/**
 *
 * @author Mostafa Talaat
 */
public class Tickets extends Trips {

    private String seatNumber;

    public Tickets(String name, String startPos, String endPos, String startTime, String endTime, String price, String discountPrecent, String stopType, String seatNumber) {
        super(name, startPos, endPos, startTime, endTime, price, discountPrecent, stopType);
        this.seatNumber = seatNumber;
    }

    public String calculate(boolean VIP, String discountPrecent) {
        if (VIP) {
            double x=Double.parseDouble(getPrice()) * (1-Double.parseDouble(discountPrecent)/100);
            return (Double.toString(x));
        }
        return getPrice();
    }

    public boolean payment(double price) {
        if ((price) >= Double.parseDouble(getPrice())) {
            setPrice(Double.toString(Double.parseDouble(getPrice()) - price));
            return true;
        }
        return false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

}
