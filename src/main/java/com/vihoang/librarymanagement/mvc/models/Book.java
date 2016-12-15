package com.vihoang.librarymanagement.mvc.models;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookID;

    private String title;

    private Integer quantity;

    private String yearpublic;

    private int status;

    private int image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="callcard",joinColumns = @JoinColumn(name="bookID",referencedColumnName = "bookID"),inverseJoinColumns = @JoinColumn(name = "accountID",referencedColumnName = "accID"))
    private Set<Account> accounts;

    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "catID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    private Author author;


    @ManyToOne
    @JoinColumn(name = "pubID", referencedColumnName = "pubID")
    private Publisher publisher;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getYearpublic() {
        return yearpublic;
    }

    public void setYearpublic(String yearpublic) {
        this.yearpublic = yearpublic;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}