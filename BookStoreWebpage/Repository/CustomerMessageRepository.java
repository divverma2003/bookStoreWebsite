package psu.edu.BookStoreWebpage.Repository;

import org.springframework.stereotype.Repository;
import psu.edu.BookStoreWebpage.Model.CustomerMessage;

import java.util.List;
import java.util.Objects;

@Repository
public class CustomerMessageRepository implements CustomerMessageRepositoryInterface {
    private final List<CustomerMessage> customerMessageList;

    public CustomerMessageRepository(List<CustomerMessage> customerMessageList) {
        this.customerMessageList = customerMessageList;
    }

    @Override
    public List<CustomerMessage> getCustomerMessages() {
        return customerMessageList;
    }

    @Override
    public void addCustomerMessage(String name, String email, String subject, String body) {
        customerMessageList.add(new CustomerMessage(name,email,subject,body));
    }

    @Override
    public CustomerMessage getCustomerMessageByEmail(String email) {
        for (CustomerMessage c : customerMessageList) {
            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }

    @Override
    public void deleteCustomerMessage(String email) {
        customerMessageList.removeIf(c -> Objects.equals(c.getEmail(), email));
    }
}
