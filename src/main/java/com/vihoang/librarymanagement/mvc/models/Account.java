package com.vihoang.librarymanagement.mvc.models;

import sun.security.util.Password;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MyPC on 14/12/2016.
 */
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accID;

    private String username;

    private String displayname;

    private String password;

    @ManyToMany(mappedBy = "accounts")
    private Set<Book> books;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="roleID",referencedColumnName = "roleID")
    private Role role;

    public Long getAccID() {
        return accID;
    }

    public void setAccID(Long accID) {
        this.accID = accID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
