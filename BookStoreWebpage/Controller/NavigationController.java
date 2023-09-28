package psu.edu.BookStoreWebpage.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/about-us")
    public String careers() {
        return "about-us";
    }

    @GetMapping("/contact-us")
    public String contact() {
        return "contact-us";
    }

    @GetMapping("/admin/edit-options")
    public String editOptions() {
        return "edit-options";
    }

}
