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

    private int seatNumber;

    public Tickets(String name, String startPos, String endPos, double startTime, double endTime, double price, double discountPrecent, int stopType, int seatNumber) {
        super(name, startPos, endPos, startTime, endTime, price, discountPrecent, stopType);
        this.seatNumber = seatNumber;
    }

    public double calculate(boolean VIP, double discountPrecent) {
        if (VIP) {
            return (getPrice() * discountPrecent);
        }
        return getPrice();
    }

    public boolean payment(double price) {
        if (price >= getPrice()) {
            setPrice(getPrice() - price);
            return true;
        }
        return false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

}
