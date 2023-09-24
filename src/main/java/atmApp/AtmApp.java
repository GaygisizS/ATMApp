package atmApp;

import java.util.Scanner;

public class AtmApp {
    static String cardNumber = "1234 5678 9101 1121";
    static String password = "1234";
    static double balance = 1000.0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean entrySuccessful = false;

        while (!entrySuccessful) {
            System.out.print("Card Number (with spaces in between): ");
            String enteredCardNumber = scanner.nextLine();

            System.out.print("Password: ");
            String enteredPass = scanner.nextLine();

            if (enteredCardNumber.equalsIgnoreCase(cardNumber) && enteredPass.equalsIgnoreCase(password)) {
                entrySuccessful = true;
            } else {
                System.out.println("Incorrect card number or password. Please try again.");
            }
        }

        System.out.println("Entry successful!");

        while (true) {
            System.out.println("\nTransactions:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdrawing Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Change Password");
            System.out.println("6. Exit");
            System.out.print("Your selection: ");

            int transaction = scanner.nextInt();
            scanner.nextLine(); // Boş satırı oku

            switch (transaction) {
                case 1:
                    System.out.println("Current Balance: " + balance + " $");
                    break;
                case 2:
                    System.out.print("Amount to be deposited: ");
                    double amountdeposited = scanner.nextDouble();
                    scanner.nextLine(); // Boş satırı oku
                    balance += amountdeposited;
                    System.out.println(amountdeposited + " $ has been deposited. New balance: " + balance + " $");
                    break;
                case 3:
                    System.out.print("Amount to Withdraw: ");
                    double amountWithdrawn = scanner.nextDouble();
                    scanner.nextLine(); // Boş satırı oku

                    if (amountWithdrawn <= balance) {
                        balance -= amountWithdrawn;
                        System.out.println(amountWithdrawn + " $ withdrawn. New balance: " + balance + " $");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.print("Recipient IBAN (26 characters starting with TR): ");
                    String iban = scanner.nextLine();

                    if (iban.startsWith("TR") && iban.length() == 26) {
                        System.out.print("Amount to be sent: ");
                        double amountSent = scanner.nextDouble();
                        scanner.nextLine(); // Boş satırı oku

                        if (amountSent <= balance) {
                            balance -= amountSent;
                            System.out.println(amountSent + "$ sent New balance: " + balance + " $");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Incorrect IBAN.");
                    }
                    break;
                case 5:
                    System.out.print("Current Password: ");
                    String currentPassword = scanner.nextLine();

                    if (currentPassword.equals(password)) {
                        System.out.print("New Password: ");
                        String newPassword = scanner.nextLine();
                        password = newPassword;
                        System.out.println("Password has been changed.");
                    } else {
                        System.out.println("Incorrect passworde.");
                    }
                    break;
                case 6:
                    System.out.println("Exit is in progress...");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}

