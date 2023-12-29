package com.ProPenny;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class controllerSignIn {
    static Scanner scanner = new Scanner(System.in);
    public static void userAct(String userName) throws SQLException {

        controllerDb controllerDb = new controllerDb();

        while (true) {
            System.out.println("------------------------");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Balance");
            System.out.println("4. Sign Out \n------------------------");
            System.out.print("Choose an option: ");

            int choice;

            if (scanner.hasNextInt()) {

                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("------------------------");

                switch (choice) {
                    case 1:
                        System.out.print("Press '+' for credit or '-' for debit: ");
                        String CredOrDeb = scanner.nextLine();
                        char sign = CredOrDeb.charAt(0);
                        double amount;
                        String type;
                        String description;

                        if(CredOrDeb.length() == 1){
                            switch (sign) {
                                case '+':
                                    type = "CR";
                                    System.out.print("Enter transaction description: ");
                                    description = scanner.nextLine();
                                    System.out.print("Enter Credit amount: Rs.");
                                    amount = scanner.nextDouble();
                                    controllerDb.addUserData(userName, LocalDateTime.now(), description, amount, type);


                                    break;
                                case '-': {
                                    type = "DR";
                                    System.out.print("Enter transaction description: ");
                                    description = scanner.nextLine();
                                    System.out.print("Enter Debit amount: Rs.");
                                    amount = (-1) * (scanner.nextDouble());
                                    controllerDb.addUserData(userName, LocalDateTime.now(), description, amount, type);
                                }
                                break;

                                default:
                                    System.out.println("Invalid Sign. Please try again.");

                            }
                        }else{
                            System.out.println("Invalid Sign. Please try again.");
                        }

                        break;

                    case 2:
                        if (controllerDb.checkData(userName) == 0) {
                            System.out.println("No Transactions Found!");
                        } else {
                            System.out.println("Transactions:");
                            controllerDb.readUserData(userName);
                        }
                        break;

                    case 3:
                        double balance = controllerDb.checkBalance(userName);
                        System.out.println("Current Balance: Rs." + balance);
                        break;

                    case 4:
                        System.out.println("Signing Out. Goodbye!");
                        Main.main(new String[]{});


                    default:
                        System.out.println("------------------------\nPlease Enter Valid Input :(");
                }
            }else{
                System.out.println("------------------------\nPlease Enter Valid Input :(");
                scanner.nextLine();
            }
        }
    }
}


