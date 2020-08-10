package com.victorp.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", nullable = false, length = 50, unique = true)
    private String login;
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "groups")
    private String group;
    @Column(name = "idRole")
    private static final int idRole = 2;



    public Trainer() {
    }

    public Trainer(Long id, String login, String password, String firstName, String lastName, String birthdate, String email, String group) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static int getIdRole() {
        return idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) &&
                Objects.equals(login, trainer.login) &&
                Objects.equals(password, trainer.password) &&
                Objects.equals(firstName, trainer.firstName) &&
                Objects.equals(lastName, trainer.lastName) &&
                Objects.equals(birthdate, trainer.birthdate) &&
                Objects.equals(email, trainer.email) &&
                Objects.equals(group, trainer.group);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, birthdate, email, group);
    }
}


