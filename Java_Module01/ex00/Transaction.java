import java.util.UUID;

enum TransferCategory {
    DEBIT,
    CREDIT
}

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private int transferAmount;
    private TransferCategory transferCategory;
    

    /*
     * Constructor
     */
    public Transaction() {
        this.id = UUID.randomUUID();
    }

    /*
     * Parameterized Constructor
     */
    public Transaction(UUID id, User sender, User recipient, TransferCategory transferCategory, int transferAmount) {
        
        if ((transferCategory == TransferCategory.DEBIT && transferAmount < 0)
            || (transferCategory == TransferCategory.CREDIT && transferAmount > 0)) {
                this.id = id;
                this.sender = sender;
                this.recipient = recipient;
                this.transferAmount = transferAmount;
                this.transferCategory = transferCategory;
            }
            
    }


    /*
     * @return recipient
     */
    public User getRecipient() {
        return recipient;
    }

    /*
     * @return sender
     */
    public User getSender() {
        return sender;
    }

    /*
     * @return transferAmount
     */
    public int getTransferAmount() {
        return transferAmount;
    }

    /*
     * @return id
     */
    public UUID getId() {
        return id;
    }

    /*
     * @return transferCategory
     */
    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    /*
     * @param transferCategory
     */
    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }

    /*
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }


    /*
     * @param recipient
     */
    public void setRecipient(User recipient) {
        // check if recipient is not the same as sender
        if (this.sender != recipient) {
            this.recipient = recipient;
        }
    }

    /*
     * @param sender
     */
    public void setSender(User sender) {
        // check if sender is not the same as recipient and if the sender has enough balance
        if (this.recipient != sender) {
            this.sender = sender;
        }
    }

    /*
     * @param transferAmount
     */
    public void setTransferAmount(int transferAmount) {
        // check if transferAmount is valid for both users
        if ((transferCategory == TransferCategory.DEBIT && transferAmount < 0)
        || (transferCategory == TransferCategory.CREDIT && transferAmount > 0)) {
            this.transferAmount = transferAmount;
        }
    }
}
