import java.util.LinkedList;

public class ListOfEmails {
    private LinkedList<Email> emails;

    public ListOfEmails() {
        emails = new LinkedList<>();
    }

    public void add(Email E) {
        emails.add(E);
    }

    public Email read(int id) {
        for (Email email : emails) {
            if (email.getId() == id) {
                email.markAsRead();
                return email;
            }
        }
        return null;
    }

    public Email delete(int id) {
        for (Email email : emails) {
            if (email.getId() == id) {
                emails.remove(email);
                return email;
            }
        }
        return null;
    }

    public void showAll(boolean flag) {
        for (Email email : emails) {
            if (flag || !email.isRead()) {
                System.out.printf("Email id: %d\nSubject: %s\nBody: %s\nTime received: %d\nStatus: %s\n\n",
                        email.getId(),
                        truncate(email.getSubject(), 25),
                        truncate(email.getMessage(), 40),
                        email.getTime(),
                        email.isRead() ? "Read" : "Unread");
            }
        }
    }

    private String truncate(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length) + "...";
        } else {
            return str;
        }
    }
    
    public Email archiveOrDelete(int id) {
        for (Email email : emails) {
            if (email.getId() == id) {
                emails.remove(email);
                return email;
            }
        }
        return null;
    }

    public void clear(ListOfEmails Trash) {
        Trash.emails.addAll(this.emails);
        this.emails.clear();
    }
}
