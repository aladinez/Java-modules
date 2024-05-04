

/**
 * UsersList
 */
public interface UsersList {

    public int add(User user);

    public User getById(int id);

    public User getByIndex(int index);

    public int getNumberOfUsers();

}