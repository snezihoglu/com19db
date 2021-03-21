package students.alatoo.com19db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class Com19dbApplication {

    @Autowired
    private StudentsRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Com19dbApplication.class, args);
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("Students", repo.findAll());
        return "index";
    }
    @GetMapping("/aboutapi")
    public String aboutapi(){
        return "aboutapi";
    }



}
