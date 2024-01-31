import java.util.Scanner;

public class EmailApplication {
    private ListOfEmails Inbox;
    private ListOfEmails Archive;
    private ListOfEmails Trash;

    public EmailApplication() {
        Inbox = new ListOfEmails();
        Archive = new ListOfEmails();
        Trash = new ListOfEmails();
    }

    public static void main(String[] args) {
        EmailApplication app = new EmailApplication();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine().trim();

            if (line.startsWith("N")) {
                String subject = sc.nextLine();
                int id = Integer.parseInt(sc.nextLine());
                String message = sc.nextLine();
                long time = Long.parseLong(sc.nextLine());
                app.Inbox.add(new Email(subject, id, message, time));
            } else if (line.startsWith("R")) {
                int id = Integer.parseInt(line.split(" ")[1]);
                Email email = app.Inbox.read(id);
                if (email != null) {
                    System.out.printf("Email id: %d\nSubject: %s\nBody: %s\nTime received: %d\nStatus: Read\n\n",
                            email.getId(), email.getSubject(), email.getMessage(), email.getTime());
                } else {
                    System.out.println("No such email.");
                }
            } else if (line.startsWith("A")) {
                int id = Integer.parseInt(line.split(" ")[1]);
                Email email = app.Inbox.archiveOrDelete(id);
                if (email != null) {
                    app.Archive.add(email);
                    System.out.println("Email " + id + " archived.");
                } else {
                    System.out.println("No such email.");
                }
            } else if (line.startsWith("D")) {
                int id = Integer.parseInt(line.split(" ")[1]);
                Email email = app.Inbox.archiveOrDelete(id);
                if (email != null) {
                    app.Trash.add(email);
                    System.out.println("Email " + id + " is deleted.");
                } else {
                    System.out.println("No such email.");
                }
            } else if (line.startsWith("S")) {
                String folder = line.split(" ")[1];
                switch (folder) {
                    case "Inbox":
                        app.Inbox.showAll(true);
                        break;
                    case "Archive":
                        app.Archive.showAll(true);
                        break;
                    case "Trash":
                        app.Trash.showAll(true);
                        break;
                }
            } else if (line.startsWith("U")) {
                String folder = line.split(" ")[1];
                switch (folder) {
                    case "Inbox":
                        app.Inbox.showAll(false);
                        break;
                    case "Archive":
                        app.Archive.showAll(false);
                        break;
                    case "Trash":
                        app.Trash.showAll(false);
                        break;
                }
            } else if (line.startsWith("C")) {
                String folder = line.split(" ")[1];
                switch (folder) {
                    case "Inbox":
                        app.Inbox.clear(app.Trash);
                        break;
                    case "Archive":
                        app.Archive.clear(app.Trash);
                        break;
                    case "Trash":
                        app.Trash = new ListOfEmails();
                        break;
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
