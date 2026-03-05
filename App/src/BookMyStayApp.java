import java.util.Scanner;

public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     Welcome to BookMyStay      ");
        System.out.println("================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nHello " + name + "!");
        System.out.println("Find the best hotels for your stay.");

        System.out.println("\nAvailable Options:");
        System.out.println("1. Search Hotels");
        System.out.println("2. View Bookings");
        System.out.println("3. Exit");

        System.out.print("\nChoose an option: ");
        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("Searching Hotels...");
        }
        else if(choice == 2) {
            System.out.println("Showing your bookings...");
        }
        else if(choice == 3) {
            System.out.println("Thank you for using BookMyStay!");
        }
        else {
            System.out.println("Invalid option!");
        }

        sc.close();
    }
}