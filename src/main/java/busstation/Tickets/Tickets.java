/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Tickets;

/**
 *
 * @author Mostafa Talaat
 */
public abstract class Tickets {

    private double price;
    private boolean refundable;
    private boolean priority;
    private double discountPrecent;

    public double calculate(boolean VIP) {
        if (VIP) {
            return (price * discountPrecent);
        }
        return price;
    }
    public boolean payment(double price){
        if(price >= this.price)
        {
            this.price-=price;
            return true;
        }
        return false;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public double getDiscountPrecent() {
        return discountPrecent;
    }

    public void setDiscountPrecent(double discountPrecent) {
        this.discountPrecent = discountPrecent;
    }

    public Tickets(double price, boolean refundable, boolean priority, double discountPrecent) {
        this.price = price;
        this.refundable = refundable;
        this.priority = priority;
        this.discountPrecent = discountPrecent;
    }

}
