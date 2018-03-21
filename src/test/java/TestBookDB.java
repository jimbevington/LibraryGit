//import db.DBHelper;
//import models.Book;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class TestBookDB {
//
//    private Book book;
//
//    @After
//    public void tearDown() throws Exception {
//        DBHelper.delete(book);
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        Book book  =  new Book("All Out War", "Tim Shipman");
//        DBHelper.saveOrUpdate(book);
//    }
//
//    @Test
//    public void canSaveBook() {
//        List<Book> books = DBHelper.getAll(Book.class);
//        assertEquals(1, books.size());
//    }
//
//    @Test
//    public void canUpdateBook() {
//        Book foundBook = DBHelper.find(Book.class, book.getId());
//        foundBook.setAuthor("Allen Carr");
//        DBHelper.saveOrUpdate(foundBook);
//        foundBook = DBHelper.find(Book.class, book.getId());
//        assertEquals("Allen Carr", foundBook.getAuthor());
//    }
//}
