package students.alatoo.com19db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsRepository StudentsRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewStudent(@RequestBody Students student) {
        StudentsRepository.save(student);
        return "OK";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Students> getAllStudents() {
        return StudentsRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Students one(@PathVariable Integer id) {
        return StudentsRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/{id}")
    public @ResponseBody Students put(@RequestBody Students replaceStudents, @PathVariable Integer id) {
        return StudentsRepository.findById(id).map(Students -> {
            Students = replaceStudents;
            Students.setId(id);
            return StudentsRepository.save(Students);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void del(@PathVariable Integer id) {
        StudentsRepository.deleteById(id);
    }

}
