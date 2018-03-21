package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="borrowers")
public class Borrower {

    private int id;
    private String name;
    private Set<Book> books;

    public Borrower() {
    }

    public Borrower(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
