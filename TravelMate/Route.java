public class Route {
    private String routeId;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Route(String routeId, String source, String destination, int totalSeats) {
        this.routeId = routeId;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    @Override
    public String toString() {
        return "RouteID: " + routeId + ", " + source + " → " + destination +
               ", Seats Available: " + availableSeats + "/" + totalSeats;
    }
}
