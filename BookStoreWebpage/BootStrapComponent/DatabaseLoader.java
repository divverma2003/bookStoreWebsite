package psu.edu.BookStoreWebpage.BootStrapComponent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import psu.edu.BookStoreWebpage.Model.DateTime;
import psu.edu.BookStoreWebpage.Model.Genre;
import psu.edu.BookStoreWebpage.Repository.BookRepository;
import psu.edu.BookStoreWebpage.Repository.CustomerMessageRepository;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final BookRepository bookRepository;
    private final CustomerMessageRepository customerMessageRepository;

    public DatabaseLoader(BookRepository bookRepository, CustomerMessageRepository customerMessageRepository) {
        this.bookRepository = bookRepository;
        this.customerMessageRepository = customerMessageRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //default stock
        bookRepository.addBook(1000,"Moby Dick",  9780393972832L, new DateTime("10/18/1951"), Genre.FICTION, "Herman Melville",17.49);
        bookRepository.addBook(5956,"The Great Gatsby",9780333791035L, new DateTime("4/10/1925"), Genre.CLASSICS, "F. Scott Fitzgerald",34.49);
        bookRepository.addBook(3182,"The Lightning Thief", 9780307245304L, new DateTime("6/28/2005"), Genre.FICTION, "Rick Riordan",25.99);
        bookRepository.addBook(3189,"The Call of Cthulhu", 9780933635586L, new DateTime("2/1/1928"), Genre.HORROR, "H.P Lovecraft",16.99);
        bookRepository.addBook(2057,"Naruto, Vol 2.", 9783551762528L, new DateTime("6/2/2000"), Genre.FICTION, "Masashi Kishimoto",19.99);
        bookRepository.addBook(1053,"Little Women",  9780886463151L, new DateTime("1/1/1868"), Genre.CLASSICS, "Louisa May Alcott",23.59);
        bookRepository.addBook(4663,"The Alchemist",  9780694524440L, new DateTime("4/25/1993"), Genre.FICTION, "Paulo Coelho",31.49);
        bookRepository.addBook(3095,"Life On Earth",  9780002190916L, new DateTime("5/16/2019"), Genre.NONFICTION, "David Attenborough",14.49);
        bookRepository.addBook(1701,"No Longer Human", 9780811204811L , new DateTime("1/1/1948"), Genre.HORROR, "Osamu Dazai",15.99);
        bookRepository.addBook(8453,"The Fault in Our Stars",  9783844906288L, new DateTime("1/10/2012"), Genre.ROMANCE, "John Green",28.99);

        customerMessageRepository.addCustomerMessage("Elle White","woahelle203@gmail.com", "Book Refund", "My book came in damaged! I demand a refund!");
        customerMessageRepository.addCustomerMessage("Jocelyn","itsjoss@gmail.com", "Book Inventory", "Do you happen to have a copy of 'The Hunger Games: Catching Fire'? I've seen the movie and really want to read the book! Have a good day!");
        customerMessageRepository.addCustomerMessage("Ethan","ethan9829@gmail.com", "Books are lame lol", "Books are for nerds!");

        System.out.println("Application Launched");
    }
}
