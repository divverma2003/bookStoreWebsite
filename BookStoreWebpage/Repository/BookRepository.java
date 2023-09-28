package psu.edu.BookStoreWebpage.Repository;

import org.springframework.stereotype.Repository;
import psu.edu.BookStoreWebpage.Model.Book;
import psu.edu.BookStoreWebpage.Model.DateTime;
import psu.edu.BookStoreWebpage.Model.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository implements BookRepositoryInterface{
    private final List<Book> bookList;

    public BookRepository(){
        this.bookList = new ArrayList<>();

    }
    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public void addBook(Integer bookId, String title, Long ISBN, DateTime datePublished,Genre genre, String author, Double price) {
        Book newBook = new Book(bookId, title, ISBN, datePublished, genre, author, price);
        bookList.add(newBook);
    }

    @Override
    public void deleteBook(Integer gameId) {
        bookList.removeIf(b -> Objects.equals(b.getBookId(), gameId));
    }

    @Override
    public Book getBookById(Integer bookId) {
        for(Book b : bookList)
            if(b.getBookId().equals(bookId))
                return b;
        return null;
    }
}
