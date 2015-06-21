package by.academy.it.entity;

//import javax.persistence.*;
//import java.io.Serializable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class User implements Serializable {

    private static final long serialVersionUID = -2048506946252497236L;

    //    private static final long serialVersionUID =p ;
    private int id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private UserRole role;

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, UserRole role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "role_id")
//    @Enumerated(EnumType.ORDINAL)
    public int getRole() {
        return role.ordinal();
    }

    public void setRole(int role) {
        this.role = UserRole.values()[role];
    }
/*
    public void setRole(UserRole role) {
        this.role = role;
    }
*/

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }
}
