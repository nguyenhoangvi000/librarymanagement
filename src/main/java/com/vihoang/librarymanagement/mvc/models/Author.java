package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MyPC on 14/12/2016.
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorID;

    private String authorName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Book> books;

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
