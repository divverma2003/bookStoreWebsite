package psu.edu.BookStoreWebpage.Repository;
import psu.edu.BookStoreWebpage.Model.Book;
import psu.edu.BookStoreWebpage.Model.DateTime;
import psu.edu.BookStoreWebpage.Model.Genre;

import java.util.List;

public interface BookRepositoryInterface {
    List<Book> getBooks();

    void addBook(Integer bookId, String title, Long ISBN, DateTime datePublished, Genre genre, String author, Double price);

    void deleteBook(Integer bookId);

    Book getBookById(Integer bookId);
}
