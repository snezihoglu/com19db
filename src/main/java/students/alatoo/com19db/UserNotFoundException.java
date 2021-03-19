package students.alatoo.com19db;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
            super("Could not find the user " + id);
    }
}
