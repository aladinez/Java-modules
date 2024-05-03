import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Transaction head;
    private Transaction tail;
    private int size;

    /**
     * Constructor
     */
    public TransactionsLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add transaction to the list
     * 
     * @param transaction
     */
    public void add(Transaction node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Remove transaction by id
     * 
     * @param id
     * @return transaction
     */
    public void removeById(UUID id) {
        Transaction current = head;
        Transaction previous = null;

        while (current != null) {
            if (current.getId().equals(id)) {
                if (previous == null) { // current is head
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
        throw new TransactionNotFoundException("Transaction not found by id: " + id);
    }

    /**
     * Convert list to array
     */
    /**
     * Convert list to array
     * 
     * @return array of transactions
     */
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        Transaction current = head;
        int index = 0;
        while (current != null) {
            transactions[index] = current;
            current = current.getNext();
            index++;
        }
        return transactions;
    }

    /**
     * Get number of transactions
     * 
     * @return number of transactions
     */
    public int getNumberOfTransactions() {
        return size;
    }

}