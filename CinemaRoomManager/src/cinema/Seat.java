package cinema;

public class Seat {
    private final int ROW;
    private final int SEAT_IN_ROW;
    private final int TICKET_PRICE;
    private boolean isReserved;

    public Seat(int row, int seatInRow, int ticketPrice) {
        this.ROW = row;
        this.SEAT_IN_ROW = seatInRow;
        this.TICKET_PRICE = ticketPrice;
        this.isReserved = false;
    }

    public int getRow() {
        return this.ROW;
    }

    public int getSeatInRow() {
        return this.SEAT_IN_ROW;
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