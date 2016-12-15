package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MyPC on 15/12/2016.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleID;

    private String roleName;

    @ManyToMany(mappedBy = "roles",targetEntity = Permission.class,fetch = FetchType.LAZY)
    private Set<Permission> permissions;

    @OneToOne(mappedBy = "role")
    private Account account;

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }


    public Account getBook() {
        return account;
    }

    public void setBook(Account account) {
        this.account = account;
    }
}
