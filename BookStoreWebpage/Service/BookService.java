package psu.edu.BookStoreWebpage.Service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import psu.edu.BookStoreWebpage.Model.Book;
import psu.edu.BookStoreWebpage.Model.DateTime;
import psu.edu.BookStoreWebpage.Model.Genre;
import psu.edu.BookStoreWebpage.Repository.BookRepository;

import java.util.List;
import java.util.Objects;

import static psu.edu.BookStoreWebpage.Model.DateTime.dateValidator;

@Service
public class BookService implements BookServiceInterface {
    private final BookRepository bookRepository;
    public final Integer MINIMUM = 1;
    public final Integer MAXIMUM = 10000;
    public final Integer RANGE = MAXIMUM-MINIMUM+1;

    public BookService(BookRepository bookRepository) {
        //constructor injection
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public String validateFormSubmit(String title, String ISBN, String datePublished, String genre, String author, String price) {

        String errors = null;

        if(!StringUtils.hasText(title)){
            errors= "A title is required to add a book! ";
        }

        if(!StringUtils.hasText(ISBN)){
            if(!StringUtils.hasText(errors)){
                errors="An ISBN is required to add a book! ";
            }
            else{
                errors+= "An ISBN is required to add a book! ";
            }
        }

        if(!StringUtils.hasText(datePublished)){
            if(!StringUtils.hasText(errors)){
                errors="A date is required to add a book! ";
            }
            else{
                errors+= "A date is required to add a book! ";
            }
        }

        if(StringUtils.hasText(datePublished)) {
            String dateErrors = dateValidator(datePublished);
            if(StringUtils.hasText(dateErrors)) {
                if (!StringUtils.hasText(errors)) {
                    errors = dateValidator(datePublished) + " ";
                } else {
                    errors += dateValidator(datePublished) + " ";
                }
            }
        }

        if(!StringUtils.hasText(genre)){
            if(!StringUtils.hasText(errors)){
                errors="A genre is required to add a book! ";
            }
            else{
                errors+= "A genre is required to add a book! ";
            }
        }

        if(StringUtils.hasText(genre)){
            String genreErrors = validateGenre(genre);
            if(StringUtils.hasText(genreErrors)) {
                if (!StringUtils.hasText(errors)) {
                    errors = (validateGenre(genre))+ " ";
                } else {
                    errors += (validateGenre(genre))+ " ";
                }
            }
        }

        if(!StringUtils.hasText(author)){
            if(!StringUtils.hasText(errors)){
                errors="An author is required to add a book! ";
            }
            else{
                errors+= "An author is required to add a book! ";
            }
        }

        if((!StringUtils.hasText(price))){
            if(!StringUtils.hasText(errors)){
                errors="A price is required to add a book! ";
            }
            else{
                errors+= "A price is required to add a book! ";
            }
        }
        if(StringUtils.hasText(errors))
            return errors;

        return null;
    }

    @Override
    public String validateGenre(String genre) {
        switch (genre.toUpperCase()) {
            case "CLASSICS", "HORROR", "FICTION", "NONFICTION", "ROMANCE" -> {
                return null;
            }
        }
        return "Genre must be of type CLASSICS, HORROR, FICTION, NONFICTION, or ROMANCE!";
    }



    @Override
    public void editBook(Integer bookId, String title, String ISBN, String datePublished, String genre, String author, String price) {
        Book temp = bookRepository.getBookById(bookId);
        if(temp!=null){
            temp.setTitle(title);
            temp.setAuthor(author);
            temp.setGenre(Genre.valueOf(genre.toUpperCase()));
            temp.setISBN(Long.parseLong(ISBN));
            temp.setDatePublished(new DateTime(datePublished));
            temp.setPrice(Double.parseDouble(price));
        }
    }

    @Override
    public void addBook(String title, String ISBN, String datePublished, String genre, String author, String price) {
        Genre genreEnum = Genre.valueOf(genre.toUpperCase());
        Integer bookId = (int) ((Math.random() * RANGE) + MINIMUM);

        while(!ensureUniqueBookId(bookId))
        {
           bookId = (int)((Math.random() * RANGE) + MINIMUM);
        }
        bookRepository.addBook(bookId, title, Long.parseLong(ISBN), new DateTime(datePublished), genreEnum, author, Double.parseDouble(price));
    }

    @Override
    public boolean ensureUniqueBookId(Integer bookId){
        for(Book b: bookRepository.getBooks()){
            if(Objects.equals(b.getBookId(), bookId))
                return false;
        }
        return true;
    }
    @Override
    public void deleteBook(Integer gameId) {
        bookRepository.deleteBook(gameId);
    }

    @Override
    public Book getBookById(Integer gameId) {
        return bookRepository.getBookById(gameId);
    }
}
