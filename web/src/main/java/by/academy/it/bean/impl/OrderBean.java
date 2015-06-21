package by.academy.it.bean.impl;

import by.academy.it.bean.*;

//@Repository
public class OrderBean implements IOrderBean {
    private int id;
    private double sum;
    private boolean paid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
