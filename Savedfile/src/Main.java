import java.util.List;

public class Main {
    public static void main(String[] args) {
        String saveFolder = "D:\\Users\\molni\\IdeaProjects\\fileenter\\Games\\savegames";
        String saveArchive = "D:\\Users\\molni\\IdeaProjects\\fileenter\\Games\\savegames\\zip.zip";

        GameProgress gameProgress1 = new GameProgress(100, 6, 5, 30.5);
        GameProgress gameProgress2 = new GameProgress(90, 5, 4, 22.0);
        GameProgress gameProgress3 = new GameProgress(80, 4, 3, 15.2);

        gameProgress1.saveGame(saveFolder + "/save1.dat", gameProgress1);
        gameProgress2.saveGame(saveFolder + "/save2.dat", gameProgress2);
        gameProgress3.saveGame(saveFolder + "/save3.dat", gameProgress3);

        List<String> saveFolders = List.of(
                saveFolder + "/save1.dat",
                saveFolder + "/save2.dat",
                saveFolder + "/save3.dat"
        );

        gameProgress1.zipFiles(saveArchive, saveFolders);
    }
}
