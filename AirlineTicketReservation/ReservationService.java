import java.util.LinkedList;

public class ReservationService {
    private LinkedList<Reservation> reservations;

    public ReservationService() {
        this.reservations = new LinkedList<>();
    }

    public void reserveTicket(String flightNo, String personName) {
        reservations.add(new Reservation(flightNo, personName));
        System.out.println("Reservation is added successfully");
    }

    public void cancelReservation(String flightNo, String personName) {
        boolean removed = reservations.removeIf(r -> r.flightNo.equals(flightNo) && r.personName.equals(personName));
        if (removed) {
            System.out.println("Flight is removed successfully");
        } else {
            System.out.println("No flight is found");
        }
    }

    public void checkReservation(String flightNo, String personName) {
        if (reservations.stream().anyMatch(r -> r.flightNo.equals(flightNo) && r.personName.equals(personName))) {
            System.out.println("Flight exists");
        } else {
            System.out.println("No flight is found");
        }
    }

    public void listReservations() {
        System.out.println("The flights:");
        for (int i = 0; i < reservations.size(); i++) {
            System.out.println((i + 1) + ": Flight Number: " + reservations.get(i).flightNo + ", Person: " + reservations.get(i).personName);
        }
    }
}
