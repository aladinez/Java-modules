import java.util.Scanner;
import java.util.UUID;

public class Menu {
    TransactionsService transactionsService;
    Scanner in;

    public Menu() {
        this.transactionsService = new TransactionsService();
        this.in = new Scanner(System.in);
    }

    public void showMenu(int isDev) {
        System.out.println("---------------------------------------------------------");
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
        System.out.println("Enter a user name and a balance");
        String name = in.next();
        int balance = in.nextInt();
        int userId = transactionsService.addUser(name, balance);
        System.out.println("User with id = " + userId + " is added");
    }

    public void viewUserBalances() {
        System.out.println("Enter a user ID");
        int userId = in.nextInt();
        User user = transactionsService.getUserById(userId);
        System.out.println(user.getName() + " - " + user.getBalance());
    }

    public void performTransfer() {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        int senderId = in.nextInt();
        int recipientId = in.nextInt();
        int amount = in.nextInt();
        transactionsService.performTransaction(senderId, recipientId, amount);
        System.out.println("The transfer is completed");
    }

    public void viewAllTransactionsForUser() {
        System.out.println("Enter a user ID");
        int userId = in.nextInt();
        Transaction[] transactions = transactionsService.getUserTransactions(userId);
        for (Transaction transaction : transactions) {
            System.out.println("To " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getId() + ") " + transaction.getTransferAmount() + " with id = " + transaction.getId());
        }
    }

    public void removeTransfer() {
        System.out.println("Enter a user ID and a transfer ID");
        int userId = in.nextInt();
        UUID transactionId = UUID.fromString(in.next());
        Transaction transaction = transactionsService.removeTransaction(userId, transactionId);
        System.out.println("Transfer To " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getId() + ") " + -transaction.getTransferAmount() + " removed");
    }

    public void checkTransferValidity() {
        Transaction[] transactions = transactionsService.checkValidity();
        System.out.println("Check results:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getSender().getName() + "(id = " + transaction.getSender().getId() + ") has an unacknowledged transfer id = " + transaction.getId() + " from " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getId() + ") for " + transaction.getTransferAmount());
        }
    }

    public int executeOption(int option, int isDev) {
        switch (option) {
            case 1:
                this.addUser();
                break;
            case 2:
                this.viewUserBalances();
                break;
            case 3:
                this.performTransfer();
                break;
            case 4:
                this.viewAllTransactionsForUser();
                break;
            case 5:
                if (isDev == 1) {
                    this.removeTransfer();
                } else {
                    return 0;
                }
                break;
            case 6:
                if (isDev == 1) {
                    this.checkTransferValidity();
                }
                else {
                    System.out.println("Invalid option");
                }
                break;
            case 7:
                if (isDev == 1) {
                    return 0;
                }
                else {
                    System.out.println("Invalid option");
                }
                break;
            default:
                System.out.println("Invalid option");
        }
        return 1;
    }
    
    // create loop to show menu and execute option
    public void startMenu(int isDev) {
        int option = 0;
        while (true) {
            this.showMenu(isDev);
            try {
                option = in.nextInt();
                if (this.executeOption(option, isDev) == 0) {
                    break;
                }
            } catch (Exception e) {
                if (e instanceof UserNotFoundException) {
                    System.out.println(e.getMessage());
                    continue;
                } else if (e instanceof TransactionNotFoundException) {
                    System.out.println(e.getMessage());
                    continue;
                } else {
                    System.out.println("Invalid input");
                }
                in.next();
            }
        }
        in.close();
    }


}
