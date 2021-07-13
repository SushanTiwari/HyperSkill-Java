package cinema;

import java.util.Scanner;

public class Cinema {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ScreenRoom room = getScreenRoom();
        System.out.printf("%n%s%n%n", room.seatingChart());

        Seat seat = getSeat(room);
        System.out.printf("%nTicket price: $%d%n%n", seat.getTicketPrice());
        seat.reserveSeat();

        System.out.println(room.seatingChart());

    }

    private static int getInput(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    private static ScreenRoom getScreenRoom() {
        int rows = getInput("Enter the number of rows:");
        int seatsPerRow = getInput("Enter the number of seats in each row:");

        return new ScreenRoom(rows, seatsPerRow, 10, 8);
    }

    private static Seat getSeat(ScreenRoom room) {
        int row = getInput("Enter a row number:");
        int seatInRow = getInput("Enter a seat number in that row:");

        return room.getSeat(row, seatInRow);
    }
}