package cinema;

import java.util.Scanner;

public class Cinema {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ScreenRoom room = getScreenRoom();
        System.out.println();

        int selection;

        do {
            selection = getInput(menu());
            System.out.println();

            switch (selection) {
                case 1:
                    System.out.printf("%s", room.seatingChart());
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    Seat seat = getSeat(room);
                    System.out.printf("%nTicket price: $%d%n", seat.getTicketPrice());
                    seat.reserveSeat();
                    break;
            }
        } while (selection != 0);
    }

    private static String menu() {
        return "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit";
    }

    private static int getInput(String message) {
        System.out.printf("%s%n", message);
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