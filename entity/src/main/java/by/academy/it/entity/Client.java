package by.academy.it.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Client extends User implements Serializable {

    private static final long serialVersionUID = -6666071239967252762L;

    private int bankAccountID;
    private BankAccount bankAccount;

    public Client() {
    }

    public Client(String login, String password, String firstName, String lastName, UserRole role, int bankAccountID) {
        super(login, password, firstName, lastName, role);
        this.bankAccountID = bankAccountID;
    }

    @Column(name = "bank_id ")
    public int getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(int bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    @OneToOne(fetch = FetchType.LAZY)
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

        Client client = (Client) o;

        if (bankAccountID != client.bankAccountID) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bankAccountID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "bankAccountID=" + bankAccountID +
                '}';
    }
}
