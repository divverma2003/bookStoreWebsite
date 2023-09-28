package psu.edu.BookStoreWebpage.Repository;

import psu.edu.BookStoreWebpage.Model.CustomerMessage;

import java.util.List;

public interface CustomerMessageRepositoryInterface {
    List<CustomerMessage> getCustomerMessages();

    void addCustomerMessage(String name, String email, String subject, String body);

    CustomerMessage getCustomerMessageByEmail(String email);

    void deleteCustomerMessage(String email);
}
