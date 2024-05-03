import java.util.UUID;

public class User {
    private int id;
    private String name;
    private int balance;
    TransactionsList transactionsList;

    /*
     * @param id
     * @param name
     * @param balance
     */
    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance >= 0) {
            this.balance = balance;
        }
        transactionsList = new TransactionsLinkedList();
    }

    /*
     * @param amount
     */
    public void setBalance(int balance) {
        if (balance >= 0)
        this.balance = balance;
    }

    /*
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /*
     * @return id
     */
    public int getId() {
        return id;
    }

    /*
     * @return name
     */
    public String getName() {
        return name;
    }

    /*
     * @param name
     */
    public String setName(String name) {
        return this.name = name;
    }

    public TransactionsList getTransactionsList() {
        return transactionsList;
    }

    public void addTransaction(Transaction transaction) {
        transactionsList.add(transaction);
    }

    public void removeTransactionById(UUID id) {
        transactionsList.removeById(id);
    }
}
