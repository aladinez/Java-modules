
public class User {
    private int id;
    private String name;
    private int balance;

    /*
     * @param id
     * @param name
     * @param balance
     */
    public User(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        if (balance >= 0) {
            this.balance = balance;
        }
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
     * @param id
     */
    public int setId(int id) {
        return this.id = id;
    }
    /*
     * @param name
     */
    public String setName(String name) {
        return this.name = name;
    }
}
