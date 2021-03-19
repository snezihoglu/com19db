package students.alatoo.com19db;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id) {
            super("Could not find the student " + id);
    }
}
