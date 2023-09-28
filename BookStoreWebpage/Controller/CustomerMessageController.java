package psu.edu.BookStoreWebpage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import psu.edu.BookStoreWebpage.Model.CustomerMessage;
import psu.edu.BookStoreWebpage.Service.CustomerMessageService;

import java.util.List;

@Controller
public class CustomerMessageController {
    public final CustomerMessageService customerMessageService;

    public CustomerMessageController(CustomerMessageService customerMessageService) {
        this.customerMessageService = customerMessageService;
    }


    @GetMapping("/admin/inbox")
    public String inbox(Model model) {
        List<CustomerMessage> customerMessageList = customerMessageService.getCustomerMessages();
        model.addAttribute("customerMessageList", customerMessageList);
        return "inbox";
    }

    @GetMapping(value = "/admin/customerMessages/delete/{email}")
    public String delete(Model model, @PathVariable String email) {

        customerMessageService.deleteCustomerMessage(email);

        List<CustomerMessage> customerMessageList = customerMessageService.getCustomerMessages();
        model.addAttribute("customerMessageList", customerMessageList);
        return "inbox";
    }

    @PostMapping(value = "/contact-us")
    public String addCustomerMessage(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String subject, @RequestParam String body) {

        String error = customerMessageService.validateFormSubmit(name,email,subject,body);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("subject", subject);
            model.addAttribute("body", body);

        }
        else {
            customerMessageService.addCustomerMessage(name,email,subject,body);
            model.addAttribute("success", "Your message was sent.");
            model.addAttribute("customerMessageList",customerMessageService);
        }
        return "contact-us";
    }
}
