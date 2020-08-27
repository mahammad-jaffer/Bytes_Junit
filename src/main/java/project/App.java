/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package project;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class App {
    private static AdHandler adHandler;
    
    public static void main(String[] args) throws FileNotFoundException {
        adHandler = new AdHandler();
        Scanner scanner = new Scanner(System.in);

        String lastOption = "";

        while(!lastOption.equals("9")) {
            lastOption = showInitialMenu(scanner);
        }

        System.out.println("Thanks for visiting!");
    }

    public static String showInitialMenu(Scanner scanner) {
        System.out.println("\nSelect options(1/2/3/...):");
        System.out.println("1. View Ads");
        System.out.println("2. Add new Ad");
        System.out.println("3. View Meetings");
        System.out.println("4. Book meeting with seller");
        System.out.println("9. Exit");

        System.out.println("Selected option: ");

        String option = scanner.next();
        
        switch(option) {
            case "1":
                System.out.println(adHandler.getAllAds());
                break;
            case "2":
                addNewAd(scanner);
                break;
            case "3":
                System.out.println(adHandler.getAllMeetings());
                break;
            case "4":
                bookMeeting(scanner);
                break;
            case "9":
                break;
            default:
                System.out.println("Invalid option. Try again.");
                break;

        }
        return option;
    }

    private static void addNewAd(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter Ad info:\n");

        System.out.println("Seller ID (0/1/2):");
        int sellerID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ad Type (toy/vehicle/furniture/clothes):");
        String type = scanner.nextLine();

        System.out.println("Ad Description:");
        String description = scanner.nextLine();

        try {
            adHandler.addNewAd(description, type, sellerID);
            // adHandler.addNewAd(description, type, sellerID, LocalDateTime.now());
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Server error. Please try again later.");
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    private static void bookMeeting(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter appointment info:\n");

        System.out.println("Ad ID:");
        int adID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Name:");
        String customerName = scanner.nextLine();

        System.out.println("Preferable time for Seller to call you:");
        String meetingTime = scanner.nextLine();

        adHandler.addNewMeeting(adID, meetingTime, customerName);;
    }


}
