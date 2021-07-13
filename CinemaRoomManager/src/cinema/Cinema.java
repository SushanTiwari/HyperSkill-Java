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

            switch (selection) {
                case 1:
                    System.out.printf("%n%s%n%n", room.seatingChart());
                    break;
                case 2:
                    System.out.printf("%nTicket price: $%d%n%n", buyTicket(room));
                    break;
                case 3:
                    System.out.printf("%n%s%n%n", room.getStatistics());
                    break;
            }
        } while (selection != 0);
    }

    private static String menu() {
        return "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit";
    }

    private static int getInput(String message) {
        System.out.printf("%s%n", message);
        return scanner.nextInt();
    }

    private static ScreenRoom getScreenRoom() {
        int rows = getInput("Enter the number of rows:");
        int seatsPerRow = getInput("Enter the number of seats in each row:");

        return new ScreenRoom(rows, seatsPerRow);
    }

    private static int buyTicket(ScreenRoom room) {
        int row;
        int seatInRow;
        boolean wrongInput;
        boolean isReserved = false;

        System.out.println();

        do {
            row = getInput("Enter a row number:");
            seatInRow = getInput("Enter a seat number in that row:");

            wrongInput = row < 1 || row > room.getRows() || seatInRow < 1 || seatInRow > room.getSeatsPerRow();

            if (wrongInput) {
                System.out.println("\nWrong input!\n");
            }else {
                isReserved = room.reserveSeat(row, seatInRow);

                if (isReserved) {
                    System.out.println("\nThat ticket has already been purchased!\n");
                }
            }
        } while (wrongInput || isReserved);

        return room.getTicketPrice(row, seatInRow);
    }
}