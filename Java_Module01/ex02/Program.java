
class Program {

    public static void main(String[] args) {
        UsersList usersArrayList = new UsersArrayList();

        User[] users = {
            new User("John", 100),
            new User("Jane", 200),
            new User("Bob", 300),
            new User("John", 100),
            new User("Jane", 200),
            new User("Bob", 300)
        };

        for (User user : users) {
            usersArrayList.add(user);
        }
        System.out.println("Number of users : " + usersArrayList.getNumberOfUsers());
        for (int i = 0; i < usersArrayList.getNumberOfUsers(); i++) {
            System.out.println(usersArrayList.getByIndex(i).getName() + " == " + usersArrayList.getByIndex(i).getBalance() + " == " + usersArrayList.getByIndex(i).getId());
        }

        System.out.println("========== add more than 10 users ==========");
        for (int i = 0; i < 10; i++) {
            usersArrayList.add(new User("User" + i, 100));
        }

        System.out.println("Number of users : " + usersArrayList.getNumberOfUsers());

    }
}