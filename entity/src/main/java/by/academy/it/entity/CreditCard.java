package by.academy.it.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credit_cards")
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 9082161361447914054L;
    private int id;

    private BankAccount bankAccount;


    public CreditCard() {
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

    @OneToOne(fetch = FetchType.LAZY)
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
