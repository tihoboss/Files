import java.io.*;
import java.util.ArrayList;

public class Main {
    private static StringBuilder log = new StringBuilder();
    private static ArrayList<String> filesList = new ArrayList<>();

    public static void createDirectory(String path) {
        String directoryName = new File(path).getName();
        File folder = new File(path);
        if (folder.mkdir()) {
            log.append("Directory " + directoryName + " created successfully in " + folder.getParent() + ".\n");
        } else {
            log.append("Failed to create directory " + directoryName + " in " + folder.getParent() + ".\n");
        }
    }

    public static void createFile(String path) {
        String fileName = new File(path).getName();
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("File " + fileName + " was created in " + file.getParent() + ".\n");
                filesList.add(fileName);
            } else {
                log.append("Failed to create file " + fileName + " in " + file.getParent() + ".\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void writeToTemp(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(log.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String dirPath = "D:\\Users\\molni\\IdeaProjects\\fileenter\\Games";

        String[] folders = {"src", "res", "savegames", "temp"};
        for (String folder : folders) {
            createDirectory(dirPath + "\\" + folder);
        }

        String[] srcFolders = {"main", "test"};
        for (String folder : srcFolders) {
            createDirectory(dirPath + "\\src\\" + folder);
        }

        createFile(dirPath + "\\src\\main\\Main.java");
        createFile(dirPath + "\\src\\main\\Utils.java");

        String[] resFolders = {"drawables", "vectors", "icons"};
        for (String folder : resFolders) {
            createDirectory(dirPath + "\\res\\" + folder);
        }

        createFile(dirPath + "\\temp\\temp.txt");

        writeToTemp(dirPath + "\\temp\\temp.txt");
    }
}
