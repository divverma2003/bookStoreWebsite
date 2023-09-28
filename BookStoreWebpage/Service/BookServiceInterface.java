package psu.edu.BookStoreWebpage.Service;

import psu.edu.BookStoreWebpage.Model.Book;
import psu.edu.BookStoreWebpage.Model.DateTime;
import psu.edu.BookStoreWebpage.Model.Genre;

import java.util.List;

public interface BookServiceInterface {

    List<Book> getBooks();

    String validateFormSubmit(String title, String ISBN, String datePublished, String genre, String author, String price);

    String validateGenre(String genre);

    void editBook(Integer bookId, String title, String ISBN, String datePublished, String genre, String author, String price);

    void addBook(String title, String ISBN, String datePublished, String genre, String author, String price);

    void deleteBook(Integer gameId);

    Book getBookById(Integer bookId);

    boolean ensureUniqueBookId(Integer bookId);

}
