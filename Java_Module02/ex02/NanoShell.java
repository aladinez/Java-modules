import java.io.File;
import java.util.Scanner;

public class NanoShell {
    


    public void execute(String path) {
        Scanner sc = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            System.setProperty("user.dir", path);
            System.out.println(System.getProperty("user.dir"));
            command = sc.nextLine();
            if (command.startsWith("ls")) {
                ls(path);
            } else if (command.startsWith("mv")) {
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    mv(parts[1], parts[2]);
                } else {
                    System.out.println("Usage: mv WHAT WHERE");
                }
            } else if (command.startsWith("cd")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    cd(parts[1]);
                } else {
                    System.out.println("Usage: cd FOLDER_NAME");
                }
            }
        }
    }

    //  displays the current folder contents (file and subfolder names and sizes in KB)
    public void ls(String path) {
        try {
            File dir = new File(path);
            File[] files = dir.listFiles();
            for (File file : files) {
                System.out.println(file.getName() + " " + file.length() / 1024 + "KB");
            }
        } catch (Exception e) {
            System.out.println("Folder not found");
        }
    }

    // mv WHAT WHERE - enables to transfer or rename a file if WHERE contains a file name without a path.
    public void mv(String what, String where) {
        try {
            File file = new File(what);
            File newFile = new File(where);
            if (newFile.isDirectory()) {
                newFile = new File(where + "/" + file.getName());
                file.renameTo(newFile);
            } else {
                // rename file
                file.renameTo(newFile);
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    // cd FOLDER_NAME - changes the current directory
    public void cd(String folderName) {
        try {
            File dir = new File(folderName);
            if (dir.isDirectory()) {
                System.setProperty("user.dir", dir.getAbsolutePath());
                // print path
                System.out.println(System.getProperty("user.dir"));
            } else {
                System.out.println("Folder not found");
            }
        } catch (Exception e) {
            System.out.println("Folder not found");
        }
    }

}
