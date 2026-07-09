import java.util.Objects;

public final class Message {
    private final String message;

    public Message(String message) {
        this.message = Objects.requireNonNull(message);
    }

    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return "Message[message=" + message + "]";
    }
}