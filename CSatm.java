import java.util.Scanner;

public class CSatm {
    double acc_balance;

    CSatm(double init_bal) {
        acc_balance = init_bal;
    }

    double getBalance() {
        return acc_balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            acc_balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    boolean withdraw(double amount) {
        if (amount > 0 && acc_balance >= amount) {
            acc_balance -= amount;
            System.out.println("Withdrawal successful.");
            return true;
        } else {
            System.out.println("Withdrawal failed, enter a valid amount");
            return false;
        }
    }

    public void Menu(String userName) {
        System.out.println("Welcome, " + userName + "!");
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void account_bank(String userName) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            Menu(userName);
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    double acc_balance = getBalance();
                    System.out.println("Account acc_balance: " + acc_balance);
                    break;

                case 2:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for coming, " + userName + "!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);

        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name (user ID): ");
        String userName = sc.nextLine();

        CSatm atmMachine = new CSatm(1000.0);

        atmMachine.account_bank(userName);
        sc.close();
    }
}
