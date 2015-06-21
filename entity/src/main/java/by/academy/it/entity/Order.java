package by.academy.it.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Sam on 03.05.2015.
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = -173740336916365695L;
    private int id;

    private BankAccount bankAccount;
//    private int bankAccountID;

    private double sum;
    private boolean paid;

//    @ManyToOne
//    @JoinColumn(table = "bank_acounts", name = "id")
//    private BankAccount bankAccount;

    public Order() {
    }

    public Order(double sum, boolean paid) {
//        this.bankAccountID = bankAccountID;
        this.sum = sum;
        this.paid = paid;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "sum")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Column(name = "paid")
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (paid != order.paid) return false;
        if (Double.compare(order.sum, sum) != 0) return false;
        if (bankAccount != null ? !bankAccount.equals(order.bankAccount) : order.bankAccount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (bankAccount != null ? bankAccount.hashCode() : 0);
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (paid ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sum=" + sum +
                ", paid=" + paid +
                '}';
    }
}
