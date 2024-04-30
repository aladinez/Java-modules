
class Program {
    public static void main(String[] args) {
        User user = new User("John", 100);

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getBalance());

        User user2 = new User("Jane", 200);

        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getBalance());

        User user3 = new User("Mike", 300);

        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getBalance());

        int newId = UserIdsGenerator.getInstance().generateId();
        System.out.println(newId);

        // UserIdsGenerator idsGenerator = new UserIdsGenerator();
        // idsGenerator.generateId();
    }
    
}