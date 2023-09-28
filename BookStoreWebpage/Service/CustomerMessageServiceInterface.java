package psu.edu.BookStoreWebpage.Service;

import org.springframework.stereotype.Service;
import psu.edu.BookStoreWebpage.Model.CustomerMessage;

import java.util.List;

@Service
public interface CustomerMessageServiceInterface {
    List<CustomerMessage> getCustomerMessages();

    String validateFormSubmit(String name, String email, String subject, String body);

    void addCustomerMessage(String name, String email, String subject, String body);

    void deleteCustomerMessage(String email);

    CustomerMessage getCustomerMessageByEmail(String email);

}
