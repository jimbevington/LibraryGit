import db.DBHelper;
import models.Book;
import models.Borrower;

import java.util.List;

public class Runner {

    public static void main(String[] args) {



        Borrower borrower1 = new Borrower("Jonathan Cruickshank");
        DBHelper.saveOrUpdate(borrower1);
        Borrower borrower2 = new Borrower("Jim Bevington");
        DBHelper.saveOrUpdate(borrower2);

        Book book1 = new Book("How To Stop Smoking", "Allen Carr");
        DBHelper.saveOrUpdate(book1);
        Book book2 = new Book("All Out War", "Tim Shipman");
        DBHelper.saveOrUpdate(book2);

        Borrower foundBorrower = DBHelper.find(Borrower.class, borrower1.getId());
        List<Borrower> borrowers = DBHelper.getAll(Borrower.class);

        Book foundBook = DBHelper.find(Book.class, book1.getId());
        List<Book> books = DBHelper.getAll(Book.class);

    }

}
