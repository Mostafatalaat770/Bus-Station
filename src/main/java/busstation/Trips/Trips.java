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

    private String name;
    private String startPos;
    private String endPos;
    private double startTime;
    private double endTime;
    private double price;
    private double discountPrecent;
    private String stopType; // 1 : Non-Stop, 2 : One-Stop, 3 : Many-Stops.

    public Trips(String name, String startPos, String endPos, double startTime, double endTime, double price, double discountPrecent, String stopType) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = endPos;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.discountPrecent = 1 - (discountPrecent / 100);
        this.stopType = stopType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPos() {
        return startPos;
    }

    public void setStartPos(String startPos) {
        this.startPos = startPos;
    }

    public String getEndPos() {
        return endPos;
    }

    public void setEndPos(String endPos) {
        this.endPos = endPos;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrecent() {
        return discountPrecent;
    }

    public void setDiscountPrecent(double discountPrecent) {
        this.discountPrecent = discountPrecent;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

}
