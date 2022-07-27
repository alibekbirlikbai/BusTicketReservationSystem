package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    private int id;
    private String login;
    private String password;

    public Admin(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Admin() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
