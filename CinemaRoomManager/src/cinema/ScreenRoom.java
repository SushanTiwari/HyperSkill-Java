package cinema;

public class ScreenRoom {
    private final int HIGH_PRICE;
    private final int LOW_PRICE;
    private final int ROWS;
    private final int SEATS_PER_ROW;
    private final int NUMBER_OF_SEATS;
    private final Seat[][] seats;
    private int currentIncome;
    private int purchasedTickets;

    public ScreenRoom(int rows, int seatsPerRow) {
        this.HIGH_PRICE = 10;
        this.LOW_PRICE = 8;
        this.ROWS = rows;
        this.SEATS_PER_ROW = seatsPerRow;
        this.NUMBER_OF_SEATS = rows * seatsPerRow;
        this.seats = fillSeats();
        this.currentIncome = 0;
        this.purchasedTickets = 0;
    }

    private Seat[][] fillSeats() {
        Seat[][] seats = new Seat[this.ROWS][this.SEATS_PER_ROW];

        for (int row = 0; row < this.ROWS; row++) {
            for (int seatInRow = 0; seatInRow < this.SEATS_PER_ROW; seatInRow++) {
                seats[row][seatInRow] = new Seat(getTicketPrice(row));
            }
        }

        return seats;
    }

    public String seatingChart() {
        StringBuilder seatingChart = new StringBuilder();
        seatingChart.append("Cinema:\n");

        for (int row = -1; row < this.ROWS; row++){
            for (int seatInRow = -1; seatInRow < this.SEATS_PER_ROW; seatInRow++) {
                if (row == -1 && seatInRow == -1) {
                    seatingChart.append(" ");
                } else if (row == -1) {
                    seatingChart.append(String.format(" %d", seatInRow + 1));
                } else if (seatInRow == -1){
                    seatingChart.append(row + 1);
                } else {
                    Seat seat = this.seats[row][seatInRow];
                    seatingChart.append(String.format(" %s", !seat.isReserved() ? "S" : "B"));
                }
            }

            if (row != this.ROWS - 1) {
                seatingChart.append("\n");
            }
        }

        return seatingChart.toString();
    }

    private int getTicketPrice(int row) {
        return NUMBER_OF_SEATS <= 60 || row + this.ROWS % 2 <= this.ROWS / 2 ? this.HIGH_PRICE
                : this.LOW_PRICE;
    }

    public int getTicketPrice(int row, int seatInRow) {
        return this.seats[row - 1][seatInRow - 1].getTicketPrice();
    }

    private int totalIncome() {
        return NUMBER_OF_SEATS <= 60 ? this.NUMBER_OF_SEATS * this.HIGH_PRICE
                : this.ROWS / 2 * this.HIGH_PRICE * this.SEATS_PER_ROW
                + (this.ROWS / 2 + this.ROWS % 2) * this.LOW_PRICE * this.SEATS_PER_ROW;
    }

    private double percentageSold() {
        return (double) purchasedTickets / this.NUMBER_OF_SEATS * 100;
    }

    public String getStatistics() {
        return String.format("Number of purchased tickets: %d%n" +
                        "Percentage: %.2f%%%n" +
                        "Current income: $%d%n" +
                        "Total income: $%d",
                this.purchasedTickets, this.percentageSold(), this.currentIncome, this.totalIncome());
    }

    public boolean reserveSeat(int row, int seatInRow) {
        Seat seat = this.seats[row-1][seatInRow - 1];

        if (seat.isReserved()) {
            return true;
        }

        seat.reserveSeat();
        purchasedTickets++;
        currentIncome += seat.getTicketPrice();

        return false;
    }

    public int getRows() {
        return this.ROWS;
    }

    public int getSeatsPerRow() {
        return this.SEATS_PER_ROW;
    }
}