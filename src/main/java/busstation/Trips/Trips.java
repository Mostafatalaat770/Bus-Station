/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busstation.Trips;

/**
 *
 * @author Mostafa Talaat
 */
public abstract class Trips {
private double price;
private String distance;
private double duration;
private int stopType; // 1 : Non-Stop, 2 : One-Stop, 3 : Many-Stops.

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getStopType() {
        return stopType;
    }

    public void setStopType(int stopType) {
        this.stopType = stopType;
    }

    public Trips(double price, String distance, double duration) {
        this.price = price;
        this.distance = distance;
        this.duration = duration;
    }

}