public class Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        if (args.length == 0) {
            menu.startMenu(0);
            return;
        }
        if (args.length != 1) {
            System.out.println("Only one argument is allowed");
            return;
        }
        if (args[0].equals("--profile=dev")) {
            menu.startMenu(1);
        } else if (args[0].equals("--profile=prod") || args[0].equals("--profile=production")) {
            menu.startMenu(0);
        } else {
            System.out.println("Invalid argument");
        }
    }
}
