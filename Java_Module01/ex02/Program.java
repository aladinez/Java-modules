

class Program {

    public static void main(String[] args) {
        // (creation,initialization, printing object content on a console for UsersList.java
        UsersList usersArrayList = new UsersArrayList();
        User user1 = new User("John", 100);
        User user2 = new User("Jane", 200);
        User user3 = new User("Bob", 300);
        usersArrayList.add(user1);
        usersArrayList.add(user2);
        usersArrayList.add(user3);
        System.out.println(usersArrayList.getByIndex(0).getName());

        // (creation,initialization, printing object content on a console for UsersArrayList.java
        User user4 = new User("John", 100);
        User user5 = new User("Jane", 200);
        User user6 = new User("Bob", 300);
        usersArrayList.add(user4);
        usersArrayList.add(user5);
        usersArrayList.add(user6);
        System.out.println(usersArrayList.getByIndex(0).getName());
        
        

    }
}