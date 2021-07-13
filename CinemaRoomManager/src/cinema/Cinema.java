package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        int totalSeats = rows * seats;
        int income, firstHalf, secondHalf = 0;
        if (totalSeats < 60) {
            income = totalSeats * 10;
        } else {
            firstHalf = rows / 2;
            secondHalf = rows - firstHalf;
            income = (firstHalf * seats * 10) + (secondHalf * seats * 8);
        }
        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}