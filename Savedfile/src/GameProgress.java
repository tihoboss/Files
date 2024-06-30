import java.util.List;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
    public void saveGame(String saveFolder, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(saveFolder);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(gameProgress);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void zipFiles(String saveArchive, List<String> saveFolders) {
        try (FileOutputStream fos = new FileOutputStream(saveArchive);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for (String saveFolder : saveFolders) {
                try (FileInputStream fis = new FileInputStream(saveFolder)) {
                    ZipEntry ze = new ZipEntry(new File(saveFolder).getName());
                    zos.putNextEntry(ze);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    zos.closeEntry();
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}