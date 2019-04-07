/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Humans;

public class Driver extends Employees {

    private double salary;
    private boolean working;

    public Driver(String username, String password, String name, int age, String address, double salary, boolean working) {
        super(username, password, name, age, address);
        this.salary = salary;
        this.working = working;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

}
