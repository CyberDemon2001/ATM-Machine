
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private static final int BALANCE = 5000;
    private static int PIN = 1234;
    private static List<String> history =new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = BALANCE;

        System.out.print("Enter your PIN: ");
        int Pin = sc.nextInt();

        if (Pin == PIN) {
            while (true) {
                System.out.println("** Automated Teller Machine **");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Change PIN");
                System.out.println("5. Transaction History");
                System.out.println("6. EXIT");
                System.out.print("Choose the operation you want to perform: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to be withdrawn: ");
                        int withdraw = sc.nextInt();
                        if (balance >= withdraw) {
                            balance -= withdraw;
                            history.add("Withdraw: $"+withdraw);
                            System.out.println("Please collect your money.");
                        } else {
                            System.out.println("Insufficient Balance.");
                        }

                        break;
                    case 2:
                        System.out.print("Enter amount to be deposited: ");
                        int deposit = sc.nextInt();
                        balance += deposit;
                        System.out.println("Your money has been successfully deposited.");
                        history.add("Deposit: $"+deposit);
                        break;
                    case 3:
                        System.out.println("Balance: $" + balance);
                        break;
                    case 4:
                        System.out.print("Enter new PIN: ");
                        PIN = sc.nextInt();
                        System.out.println("PIN changed successfully.");
                        break;
                    case 5:
                        System.out.println("Transaction History:");
                        for(String record:history){
                            System.out.println(record);
                        }
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }
    }
}
