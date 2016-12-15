package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long catID;

    private String categoryName;

    @OneToMany(targetEntity = Book.class, mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Book> books;

    public Long getCat() {
        return catID;
    }

    public void setCat(Long catID) {
        this.catID = catID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
