package models;

import javax.persistence.*;

public class Book {

    private int id;
    private String title;
    private String author;
    private boolean onLoan;
    private Borrower currentBorrower;

    public Book() {
    }

    public Book(String title, String author, boolean onLoan, Borrower currentBorrower) {
        this.title = title;
        this.author = author;
        this.onLoan = onLoan;
        this.currentBorrower = currentBorrower;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name="is_on_loan")
    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Borrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }
}
