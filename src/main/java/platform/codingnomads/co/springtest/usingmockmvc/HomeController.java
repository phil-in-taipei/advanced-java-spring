package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/redirect-target")
    public String target(Model model) {
        model.addAttribute("variable", "Model Variable String");
        return "redirect-target";
    }

    @GetMapping("/back-to-redirect")
   // @ResponseBody
    public String backHome() {

        return "redirect:/redirect-target";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String adieu() {
        return "I bid you farewell";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }
}
