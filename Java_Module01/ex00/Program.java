import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User sender = new User(1, "Sender", 1000);
        User recipient = new User(2, "Recipient", 2000);

        Transaction transaction = new Transaction(UUID.randomUUID(), sender, recipient, TransferCategory.CREDIT, 500);

        System.out.println("Transaction ID: " + transaction.getId());
        System.out.println("Sender: " + transaction.getSender().getName());
        System.out.println("Recipient: " + transaction.getRecipient().getName());
        System.out.println("Transfer Amount: " + transaction.getTransferAmount());
        System.out.println("TransferCategory: " + transaction.getTransferCategory());


        Transaction transaction1 = new Transaction(UUID.randomUUID(), sender, recipient, TransferCategory.DEBIT, -500);
        System.out.println("Transaction ID: " + transaction1.getId());
        System.out.println("Sender: " + transaction1.getSender().getName());
        System.out.println("Recipient: " + transaction1.getRecipient().getName());
        System.out.println("Transfer Amount: " + transaction1.getTransferAmount());
        System.out.println("TransferCategory: " + transaction1.getTransferCategory());


    
        }
}
