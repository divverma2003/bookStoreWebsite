package psu.edu.BookStoreWebpage.Service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import psu.edu.BookStoreWebpage.Model.CustomerMessage;
import psu.edu.BookStoreWebpage.Repository.CustomerMessageRepository;

import java.util.List;

@Service
public class CustomerMessageService implements CustomerMessageServiceInterface{

    private final CustomerMessageRepository customerMessageRepository;

    public CustomerMessageService(CustomerMessageRepository customerMessageRepository) {
        this.customerMessageRepository = customerMessageRepository;
    }


    @Override
    public List<CustomerMessage> getCustomerMessages() {
        return customerMessageRepository.getCustomerMessages();
    }

    @Override
    public String validateFormSubmit(String name, String email, String subject, String body) {
        if (!StringUtils.hasText(name)) {
            return "Name is required!";
        }
        if (!StringUtils.hasText(email)) {
            return "Email is required!";
        }
        if (!StringUtils.hasText(subject)) {
            return "Subject is required!";
        }
        if (!StringUtils.hasText(body)) {
            return "Body is required!";
        }

        return null;
    }

    @Override
    public void addCustomerMessage(String name, String email, String subject, String body) {
        customerMessageRepository.addCustomerMessage(name,email,subject,body);
    }

    @Override
    public void deleteCustomerMessage(String email) {
        customerMessageRepository.deleteCustomerMessage(email);
    }


    @Override
    public CustomerMessage getCustomerMessageByEmail(String email) {
        return customerMessageRepository.getCustomerMessageByEmail(email);
    }
}
