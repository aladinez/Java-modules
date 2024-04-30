

class UsersArrayList implements UsersList {

    private User[] users = new User[10];

    public void add(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return;
            }
        }
        User[] temp = new User[users.length * 2];
        for (int i = 0; i < users.length; i++) {
            temp[i] = users[i];
        }
        temp[users.length] = user;
        users = temp;
    }

    public User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found by id: " + id);
    }

    public User getByIndex(int index) {
        if (index > 0 && index < users.length && users[index] != null) {
            return users[index];
        }
        throw new UserNotFoundException("User not found by index: " + index);

    }
}