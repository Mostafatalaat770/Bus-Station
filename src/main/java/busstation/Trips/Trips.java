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
    private String startTime;
    private String endTime;
    private String price;
    private String discountPrecent;
    private String stopType; // 1 : Non-Stop, 2 : One-Stop, 3 : Many-Stops.

    public Trips(String name, String startPos, String endPos, String startTime, String endTime, String price, String discountPrecent, String stopType) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = endPos;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.discountPrecent = discountPrecent;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrecent() {
        return discountPrecent;
    }

    public void setDiscountPrecent(String discountPrecent) {
        this.discountPrecent = discountPrecent;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

}
