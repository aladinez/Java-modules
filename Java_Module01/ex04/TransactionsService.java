import java.util.UUID;

class TransactionsService {

    private UsersList usersList;


    public TransactionsService() {
       this.usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.add(user);
    }

    public int getUserBalance(User user) {
        return user.getBalance();
    }

    public void performTransaction(int senderId, int recipientId, int amount) {
        User sender = usersList.getById(senderId);
        User recipient = usersList.getById(recipientId);

        if (sender == null) {
            throw new UserNotFoundException("User with id " + senderId + " not found");
        }

        if (recipient == null) {
            throw new UserNotFoundException("User with id " + recipientId + " not found");
        }

        if (sender.getBalance() < amount) {
            throw new IllegalTransactionException("User with id " + senderId + " has insufficient funds");
        }

        UUID transactionId = UUID.randomUUID();
        Transaction transaction = new Transaction(transactionId, sender, recipient, TransferCategory.DEBIT, -amount);
        Transaction transaction2 = new Transaction(transactionId, recipient, sender, TransferCategory.CREDIT, amount);

        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);

        sender.addTransaction(transaction);
        recipient.addTransaction(transaction2);
    }

    public Transaction[] getUserTransactions(int userId) {
        User user = usersList.getById(userId);

        return user.getTransactionsList().toArray();
    }

    public void removeTransaction(int userId, UUID transactionId) {
        User user = usersList.getById(userId);

        user.removeTransactionById(transactionId);
    } 

    public boolean contains(Transaction[] transactions, UUID transactionId) {
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(transactionId)) {
                return true;
            }
        }
        return false;
    }

    public Transaction[] getAllTransactions(User[] users) {
        Transaction[] transactions = new Transaction[0];
        for (User user : users) {
            Transaction[] userTransactions = user.getTransactionsList().toArray();
            Transaction[] temp = new Transaction[transactions.length + userTransactions.length];
            for (int i = 0; i < transactions.length; i++) {
                temp[i] = transactions[i];
            }
            for (int i = 0; i < userTransactions.length; i++) {
                temp[transactions.length + i] = userTransactions[i];
            }
            transactions = temp;
        }
        return transactions;
    }

    // • Check validity of transactions (returns an ARRAY of unpaired transactions).
    public Transaction[] checkValidity() {

        User[] users = new User[usersList.getNumberOfUsers()];
        for (int i = 0; i < users.length; i++) {
            users[i] = usersList.getByIndex(i);
        }

        // get all users transactions  in an array
        Transaction[] transactions = this.getAllTransactions(users);

        // check for unpaired transactions in transactions  array
        Transaction[] unpairedTransactions = new Transaction[0];
        for (Transaction transaction : transactions) {
            boolean isPaired = false;
            for (int i = 0; i < transactions.length; i++) {
                if (transaction.getId().equals(transactions[i].getId()) && transaction != transactions[i]) {
                    isPaired = true;
                    break;
                }
            }
            if (!isPaired && !contains(unpairedTransactions, transaction.getId())) {
                Transaction[] temp = new Transaction[unpairedTransactions.length + 1];
                for (int i = 0; i < unpairedTransactions.length; i++) {
                    temp[i] = unpairedTransactions[i];
                }
                temp[unpairedTransactions.length] = transaction;
                unpairedTransactions = temp;
            }
        }
        
        return unpairedTransactions;
    }


}