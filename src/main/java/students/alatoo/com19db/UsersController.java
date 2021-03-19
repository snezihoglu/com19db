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
        usersRepository.save(user);
        return "OK";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Users one(@PathVariable Integer id) {
        return usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")
    public @ResponseBody Users put(@RequestBody Users replaceUsers, @PathVariable Integer id) {
        return usersRepository.findById(id).map(users -> {
            users = replaceUsers;
            users.setId(id);
            return usersRepository.save(users);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void del(@PathVariable Integer id) {
        usersRepository.deleteById(id);
    }

}
