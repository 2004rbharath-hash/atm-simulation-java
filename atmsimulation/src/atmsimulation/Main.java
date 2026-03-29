package atmsimulation;

import java.util.*;

class ATM {
    private double balance = 10000;
    private int pin = 1234;

    public boolean validatePin(int userPin) {
        return this.pin == userPin;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (atm.validatePin(pin)) {
            int choice;

            do {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: ₹" + atm.checkBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double dep = sc.nextDouble();
                        atm.deposit(dep);
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        double wd = sc.nextDouble();
                        atm.withdraw(wd);
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid option!");
                }

            } while (choice != 4);

        } else {
            System.out.println("Wrong PIN!");
        }

        sc.close();
    }
}

