import java.util.*;

public class ReservationSystem {
    private static Map<String, Route> routes = new HashMap<>();
    private static Map<Integer, Ticket> tickets = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initRoutes();

        while (true) {
            System.out.println("\n====== Online Reservation System ======");
            System.out.println("1. View Routes");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> showRoutes();
                case 2 -> bookTicket();
                case 3 -> cancelTicket();
                case 4 -> showAllTickets();
                case 5 -> {
                    System.out.println("Thank you for using the system!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void initRoutes() {
        routes.put("R1", new Route("R1", "Delhi", "Mumbai", 5));
        routes.put("R2", new Route("R2", "Bangalore", "Hyderabad", 3));
        routes.put("R3", new Route("R3", "Chennai", "Kolkata", 4));
    }

    private static void showRoutes() {
        System.out.println("\n--- Available Routes ---");
        for (Route route : routes.values()) {
            System.out.println(route);
        }
    }

    private static void bookTicket() {
        showRoutes();
        System.out.print("Enter Route ID to book: ");
        String routeId = scanner.nextLine();

        Route route = routes.get(routeId);
        if (route == null) {
            System.out.println("Invalid Route ID.");
            return;
        }

        if (route.getAvailableSeats() == 0) {
            System.out.println("No seats available on this route.");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        if (route.bookSeat()) {
            Ticket ticket = new Ticket(name, routeId);
            tickets.put(ticket.getTicketId(), ticket);
            System.out.println("Ticket booked successfully!");
            System.out.println(ticket);
        } else {
            System.out.println("Booking failed.");
        }
    }

    private static void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();

        Ticket ticket = tickets.remove(ticketId);
        if (ticket != null) {
            Route route = routes.get(ticket.getRouteId());
            if (route != null) {
                route.cancelSeat();
            }
            System.out.println("Ticket cancelled: " + ticket);
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    private static void showAllTickets() {
        System.out.println("\n--- Booked Tickets ---");
        if (tickets.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        for (Ticket t : tickets.values()) {
            System.out.println(t);
        }
    }
}
