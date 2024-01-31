public class Email {
    private String subject;
    private int id;
    private String message;
    private long time; 
    private boolean read;

    public Email() {
    }

    public Email(String subject, int id, String message, long time) {
        this.subject = subject;
        this.id = id;
        this.message = message;
        this.time = time;
        this.read = false;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public long getTime() {
        return time;
    }

    public boolean isRead() {
        return read;
    }

    public void markAsRead() {
        this.read = true;
    }
}
