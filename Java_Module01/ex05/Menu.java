import java.util.Scanner;
import java.util.UUID;

public class Menu {
    TransactionsService transactionsService;

    public Menu() {
        this.transactionsService = new TransactionsService();
    }

    public void showMenu(int isDev) {
        /*
         * 1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. DEV - remove a transfer by ID
6. DEV - check transfer validity
7. Finish execution
         */

        if (isDev == 1) {
            System.out.println("1. Add a user");
            System.out.println("2. View user balances");
            System.out.println("3. Perform a transfer");
            System.out.println("4. View all transactions for a specific user");
            System.out.println("5. DEV - remove a transfer by ID");
            System.out.println("6. DEV - check transfer validity");
            System.out.println("7. Finish execution");
        } else {
            System.out.println("1. Add a user");
            System.out.println("2. View user balances");
            System.out.println("3. Perform a transfer");
            System.out.println("4. View all transactions for a specific user");
            System.out.println("5. Finish execution");
        }

    }

    public void addUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a user name and a balance");
        String name = in.next();
        int balance = in.nextInt();
        transactionsService.addUser(name, balance); // TODO : return user id
        // User with id = 2 is added
        System.out.println("User with id = " + transactionsService.usersList.size() + " is added");
    }

    public void viewUserBalances() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a user ID");
        int userId = in.nextInt();
        User user = transactionsService.getUserById(userId);
        System.out.println(user.getName() + " - " + user.getBalance());
    }

    public void performTransfer(int senderId, int recipientId, int amount) {
        transactionsService.performTransaction(senderId, recipientId, amount);
        System.out.println("The transfer is completed");
    }

    public void viewAllTransactionsForUser(int userId) {
        Transaction[] transactions = transactionsService.getUserTransactions(userId);
        for (Transaction transaction : transactions) {
            System.out.println("To " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getId() + ") " + transaction.getTransferAmount() + " with id = " + transaction.getId());
        }
    }

    public void removeTransfer(int userId, UUID transactionId) {
        transactionsService.removeTransaction(userId, transactionId);
    }

    public void executeOption(int option, int isDev) {
        switch (option) {
            case 1:
                transactionsService.addUser(name, balance);
                break;
            case 2:
                transactionsService.viewUserBalances( userId);
                break;
            case 3:
                transactionsService.performTransfer(sender, recipient, amount);
                break;
            case 4:
                transactionsService.viewAllTransactionsForUser();
                break;
            case 5:
                if (isDev == 1) {
                    transactionsService.removeTransfer();
                } else {
                    transactionsService.finishExecution();
                }
                break;
            case 6:
                if (isDev == 1) {
                    transactionsService.checkTransferValidity();
                }
                else {
                    System.out.println("Invalid option");
                }
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    


}
