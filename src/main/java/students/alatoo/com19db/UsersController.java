package students.alatoo.com19db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewUser(@RequestBody Users user) {
        usersRepository.save(user); // insert into users values (name, email);
        return "OK";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
