package by.academy.it.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = -1530210087059113560L;
    private int id;
    private double sum;
    private boolean blocked;
    private int creditCardID;


//    @Column(name = "credit_card_id")
//    @JoinColumn(name = "id")
    private CreditCard creditCard;
    private Client client;
    private List<Order> orderList = new ArrayList<Order>();


    public BankAccount() {
    }

    public BankAccount(double sum, boolean blocked, int creditCardID) {
        this.sum = sum;
        this.blocked = blocked;
        this.creditCardID = creditCardID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
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

    @Column(name = "blocked")
    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Column(name = "credit_card_id")
    public int getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(int creditCardID) {
        this.creditCardID = creditCardID;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "bankAccount", cascade = CascadeType.ALL)
    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "bankAccount", cascade = CascadeType.ALL)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bankAccount")
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (blocked != that.blocked) return false;
        if (creditCardID != that.creditCardID) return false;
        if (id != that.id) return false;
        if (Double.compare(that.sum, sum) != 0) return false;
        if (orderList != null ? !orderList.equals(that.orderList) : that.orderList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (blocked ? 1 : 0);
        result = 31 * result + creditCardID;
        result = 31 * result + (orderList != null ? orderList.hashCode() : 0);
        return result;
    }
}
