import java.util.Scanner;

public class AirlineTicketReservation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationService service = new ReservationService();

        while (true) {
            System.out.println("Enter the number from the menu:");
            System.out.println("1. Reserve a ticket");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Check reservation");
            System.out.println("4. List all reservations");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the flight number: ");
                    String flightNo = scanner.nextLine();
                    System.out.print("Enter the person name: ");
                    String personName = scanner.nextLine();
                    service.reserveTicket(flightNo, personName);
                    break;
                case 2:
                    System.out.print("Enter the flight number: ");
                    flightNo = scanner.nextLine();
                    System.out.print("Enter the person name: ");
                    personName = scanner.nextLine();
                    service.cancelReservation(flightNo, personName);
                    break;
                case 3:
                    System.out.print("Enter the flight number: ");
                    flightNo = scanner.nextLine();
                    System.out.print("Enter the person name: ");
                    personName = scanner.nextLine();
                    service.checkReservation(flightNo, personName);
                    break;
                case 4:
                    service.listReservations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
