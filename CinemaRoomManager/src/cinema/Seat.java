package cinema;

public class Seat {
    private final int TICKET_PRICE;
    private boolean isReserved;

    public Seat(int ticketPrice) {
        this.TICKET_PRICE = ticketPrice;
        this.isReserved = false;
    }

    public boolean isReserved() {
        return this.isReserved;
    }

    public void reserveSeat() {
        this.isReserved = true;
    }

    public int getTicketPrice() {
        return this.TICKET_PRICE;
    }
}