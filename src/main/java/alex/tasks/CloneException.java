package alex.tasks;

public class CloneException extends RuntimeException {
    public CloneException(Exception e) {
        super(e.getMessage());
    }
}
