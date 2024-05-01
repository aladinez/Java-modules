import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        
        User user1 = new User("John", 1000);
        User user2 = new User("Jane", 2000);
        
        Transaction transaction1 = new Transaction(UUID.randomUUID(), user1, user2, TransferCategory.DEBIT, -500);
        Transaction transaction2 = new Transaction(UUID.randomUUID(), user2, user1, TransferCategory.CREDIT, 200);

        user1.addTransaction(transaction1);
        user2.addTransaction(transaction2);

        System.out.println("User1 transactions:");
        Transaction[] user1Transactions = user1.getTransactionsList().toArray();
        for (Transaction transaction : user1Transactions) {
            // print transaction details as : John -> Mike, -500, OUTCOME, transaction id
            System.out.println(transaction.getSender().getName() + " -> " + transaction.getRecipient().getName() + ", " + transaction.getTransferAmount() + ", " + transaction.getTransferCategory() + ", " + transaction.getId());
        }

        System.out.println("User2 transactions:");
        Transaction[] user2Transactions = user2.getTransactionsList().toArray();
        for (Transaction transaction : user2Transactions) {
            System.out.println(transaction.getSender().getName() + " -> " + transaction.getRecipient().getName() + ", " + transaction.getTransferAmount() + ", " + transaction.getTransferCategory() + ", " + transaction.getId());

        }

        user1.transactionsList.removeById(transaction1.getId());
        user2.getTransactionsList().removeById(transaction2.getId());
        
        System.out.println("User1 transactions:");
        user1Transactions = user1.getTransactionsList().toArray();
        for (Transaction transaction : user1Transactions) {
            System.out.println(transaction.getSender().getName() + " -> " + transaction.getRecipient().getName() + ", " + transaction.getTransferAmount() + ", " + transaction.getTransferCategory() + ", " + transaction.getId());
        }
        
        
        System.out.println("User2 transactions:");
        user2Transactions = user2.getTransactionsList().toArray();
        for (Transaction transaction : user2Transactions) {
            System.out.println(transaction.getSender().getName() + " -> " + transaction.getRecipient().getName() + ", " + transaction.getTransferAmount() + ", " + transaction.getTransferCategory() + ", " + transaction.getId());
        }
        
        user1.transactionsList.removeById(UUID.randomUUID());
    }
}