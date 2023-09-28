package psu.edu.BookStoreWebpage.Model;

import java.util.Objects;

public class Book {
    private Integer bookId;
    private String title;
    private Long ISBN;
    private DateTime datePublished;
    private Genre genre;
    private String author;
    private Double price;

    public Book(Integer bookId,String title, Long ISBN, DateTime datePublished, Genre genre, String author,Double price)
    {
        this.bookId = bookId;
        this.title = title;
        this.ISBN = ISBN;
        this.datePublished = datePublished;
        this.genre = genre;
        this.author = author;
        this.price = price;
    }

    public DateTime getDatePublished() {
        return datePublished;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Genre getGenre() {
        return genre;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDatePublished(DateTime datePublished) {
        this.datePublished = datePublished;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book book))
            return false;
        return bookId.equals(book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
