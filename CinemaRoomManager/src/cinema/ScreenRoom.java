package cinema;

import java.util.Arrays;

public class ScreenRoom {
    private final int ROWS;
    private final int SEATS_PER_ROW;
    private final int NUMBER_OF_SEATS;
    private Seat[][] seats;
    private int highPrice;
    private int lowPrice;


    public ScreenRoom(int rows, int seatsPerRow, int highPrice, int lowPrice) {
        this.ROWS = rows;
        this.SEATS_PER_ROW = seatsPerRow;
        this.NUMBER_OF_SEATS = rows * seatsPerRow;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.seats = emptySeats();
    }

    private Seat[][] emptySeats() {
        Seat[][] seats = new Seat[this.ROWS][this.SEATS_PER_ROW];

        for (int row = 0; row < this.ROWS; row++) {
            for (int seatInRow = 0; seatInRow < this.SEATS_PER_ROW; seatInRow++) {
                seats[row][seatInRow] = new Seat(row, seatInRow, getTicketPrice(row));
            }
        }

        return seats;
    }
    public String seatingChart() {
        StringBuilder seatingChart = new StringBuilder();
        seatingChart.append("Cinema:\n");

        for (int row = 0; row <= this.ROWS; row++){
            for (int seatInRow = 0; seatInRow <= this.SEATS_PER_ROW; seatInRow++) {
                if (row == 0 && seatInRow == 0) {
                    seatingChart.append(" ");
                } else if (row == 0) {
                    seatingChart.append(String.format(" %d", seatInRow));
                } else if (seatInRow == 0){
                    seatingChart.append(row);
                } else {
                    Seat seat = this.seats[row - 1][seatInRow - 1];
                    seatingChart.append(String.format(" %s", !seat.isReserved() ? "S" : "B"));
                }
            }

            if (row != this.ROWS) {
                seatingChart.append("\n");
            }
        }

        return seatingChart.toString();
    }

    private int getTicketPrice(int row) {
        return NUMBER_OF_SEATS <= 60 || row <= this.ROWS / 2 - 1 ? this.highPrice
                : this.lowPrice;
    }

    public int getTotalIncome() {
        int totalIncome;

        if (NUMBER_OF_SEATS <= 60) {
            totalIncome = this.NUMBER_OF_SEATS * this.highPrice;
        }else {
            totalIncome = this.ROWS / 2 * this.highPrice * this.SEATS_PER_ROW
                    + (this.ROWS / 2 + this.ROWS % 2) * this.lowPrice * this.SEATS_PER_ROW;
        }

        return totalIncome;
    }

    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Seat getSeat(int row, int seatInRow) {
        return this.seats[row - 1][seatInRow - 1];
    }
}