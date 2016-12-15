package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MyPC on 14/12/2016.
 */
@Entity
@Table(name = "permisstion")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long perID;

    private String perName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "permissionID", referencedColumnName = "perID"), inverseJoinColumns = @JoinColumn(name = "accountID", referencedColumnName = "roleID"))
    private Set<Role> roles;

    public Long getPerID() {
        return perID;
    }

    public void setPerID(Long perID) {
        this.perID = perID;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }
}
