import java.time.LocalDate;

public class Ticket {
    private static int idCounter = 1;
    private int ticketId;
    private String passengerName;
    private String routeId;
    private LocalDate bookingDate;

    public Ticket(String passengerName, String routeId) {
        this.ticketId = idCounter++;
        this.passengerName = passengerName;
        this.routeId = routeId;
        this.bookingDate = LocalDate.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Passenger: " + passengerName +
               ", Route ID: " + routeId + ", Date: " + bookingDate;
    }
}
