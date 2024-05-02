
class Program {

    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();
        User jhon = new User("John", 2000);
        User mike = new User("Mike", 2000);
        transactionsService.addUser(jhon);
        transactionsService.addUser(mike);

        // print users balance
        System.out.println("John balance: " + transactionsService.getUserBalance(jhon));
        System.out.println("Mike balance: " + transactionsService.getUserBalance(mike));

        // perform transactions
        transactionsService.performTransaction(jhon.getId(), mike.getId(), 100);
        transactionsService.performTransaction(mike.getId(), jhon.getId(), 200);

        // print users balance
        System.out.println("John balance: " + transactionsService.getUserBalance(jhon));
        System.out.println("Mike balance: " + transactionsService.getUserBalance(mike));

        // print users transactions
        Transaction[] jhonTransactions = transactionsService.getUserTransactions(jhon.getId());
        System.out.println("John transactions:");
        for (Transaction transaction : jhonTransactions) {
            System.out.println(transaction.getId());
        }

        Transaction[] mikeTransactions = transactionsService.getUserTransactions(mike.getId());
        System.out.println("Mike transactions:");
        for (Transaction transaction : mikeTransactions) {
            System.out.println(transaction.getId());
        }


        // remove one transaction
        transactionsService.removeTransaction(jhon.getId(), jhonTransactions[0].getId());

        // print users transactions
        jhonTransactions = transactionsService.getUserTransactions(jhon.getId());
        System.out.println("John transactions:");
        for (Transaction transaction : jhonTransactions) {
            System.out.println(transaction.getId());
        }

        // check validity of transactions
        Transaction[] unpairedTransactions = transactionsService.checkValidity();
        System.out.println("Unpaired transactions:");
        for (Transaction transaction : unpairedTransactions) {
            System.out.println(transaction.getId());
        }
    }
}