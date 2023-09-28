package psu.edu.BookStoreWebpage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import psu.edu.BookStoreWebpage.Model.Book;
import psu.edu.BookStoreWebpage.Service.BookService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
     private final BookService bookService;

     public FormController(BookService bookservice) {
        this.bookService = bookservice;
    }

    @GetMapping("/admin/books/view")
    public String index(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @GetMapping("/browse")
    public String browse(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "browse";
    }

    @GetMapping(value = "/admin/books/add")
    public String addForm() {
        return "add";
    }

    @PostMapping(value =  "/admin/books/add-book")
    public String add(Model model, @RequestParam String title, @RequestParam String ISBN, @RequestParam String datePublished, @RequestParam String genre, @RequestParam String author, @RequestParam String price) {


        String error = bookService.validateFormSubmit(title,ISBN,datePublished,genre, author, price);
       if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("title", title);
            model.addAttribute("ISBN", ISBN);
            model.addAttribute("datePublished", datePublished);
            model.addAttribute("genre", genre);
            model.addAttribute("author", author);
            model.addAttribute("price", price);
            return "add";

        }
        else {
            bookService.addBook(title,ISBN,datePublished,genre, author, price);
         }

        model.addAttribute("success", "Changes were saved.");
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @GetMapping(value = "/admin/books/edit/{bookId}")
    public String editPage(Model model, @PathVariable Integer bookId) {

        Book book = bookService.getBookById(bookId);
        String dateInString = String.valueOf(book.getDatePublished());

        model.addAttribute("title", book.getTitle());
        model.addAttribute("ISBN", book.getISBN());
        model.addAttribute("datePublished", dateInString);
        model.addAttribute("genre", String.valueOf(book.getGenre()));
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("price", book.getPrice());
        return "/edit-book";
    }


    @PostMapping(value = "/admin/books/edit-book")
    public String editBook(Model model, @RequestParam String bookId, @RequestParam String title, @RequestParam String ISBN, @RequestParam String datePublished, @RequestParam String genre, @RequestParam String author, @RequestParam String price) {


        String error = bookService.validateFormSubmit(title,ISBN,datePublished,genre, author, price);
        if (error != null) {

            model.addAttribute("error", error);
            model.addAttribute("title", title);
            model.addAttribute("ISBN", ISBN);
            model.addAttribute("datePublished", datePublished);
            model.addAttribute("genre", genre);
            model.addAttribute("author", author);
            model.addAttribute("price", price);

        }
        else {
            model.addAttribute("success", "Changes were saved.");
            bookService.editBook(Integer.valueOf(bookId), title,ISBN,datePublished,genre, author, price);
        }

        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }


    @GetMapping(value = "/admin/books/delete/{bookId}")
    public String delete(Model model, @PathVariable Integer bookId) {

        Book book = bookService.getBookById(bookId);
        bookService.deleteBook(bookId);

        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @GetMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {

        List<Book> bookList = bookService.getBooks();
        List<Book> searchResults = new ArrayList<>();

        for(Book b: bookList){
            String title = b.getTitle().toLowerCase();
            String author =b.getAuthor().toLowerCase();
            if(title.contains(search.toLowerCase()))
                searchResults.add(b);
            else if(author.contains(search.toLowerCase()))
                searchResults.add(b);
        }
        model.addAttribute("bookList", searchResults);
        return "browse";
    }

}
