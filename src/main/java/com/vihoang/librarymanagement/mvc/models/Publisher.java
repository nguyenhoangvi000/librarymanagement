package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MyPC on 14/12/2016.
 */
@Entity
@Table(name="publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pubID;

    private String pubName;

    @OneToMany(targetEntity = Book.class,mappedBy = "publisher",fetch = FetchType.EAGER)
    private Set<Book> books;

    public Long getPubID() {
        return pubID;
    }

    public void setPubID(Long pubID) {
        this.pubID = pubID;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
