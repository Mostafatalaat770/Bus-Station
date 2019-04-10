/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Humans;

import busstation.Tickets.Tickets;
import java.util.ArrayList;

/**
 *
 * @author Mostafa Talaat
 */
public class Customer {

    private String username;
    private String password;
    private String name;
    private int age;
    private boolean specialNeeds;
    private boolean VIP;
    private double balance;
    ArrayList<Tickets> ticketsHistory = new ArrayList<>();

    public Customer(String username, String password, String name, int age, boolean specialNeeds, boolean VIP, double balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.specialNeeds = specialNeeds;
        this.VIP = VIP;
        this.balance = balance;
    }

    public void refund(Tickets ticket) {

        balance += ticket.calculate(VIP, balance);
        ticketsHistory.remove(ticket);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Tickets> getTicketsHistory() {
        return ticketsHistory;
    }

}
