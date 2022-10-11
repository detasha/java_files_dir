import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        File homeDir = new File("C:\\Games");
        File[] dirs = {
                new File(homeDir, "src"),
                new File(homeDir, "res"),
                new File(homeDir, "saveGames"),
                new File(homeDir, "temp"),
                new File(homeDir + "\\src", "main"),
                new File(homeDir + "\\src", "test"),
                new File(homeDir + "\\res", "drawables"),
                new File(homeDir + "\\res", "vectors"),
                new File(homeDir + "\\res", "icons"),
        };
        File[] files = {
                new File(homeDir + "\\src\\main", "Main.java"),
                new File(homeDir + "\\src\\main", "Utils.java"),
                new File(homeDir + "\\temp", "temp.txt"),
        };

        StringBuilder log = new StringBuilder();
        if (!homeDir.exists()) {
            log.append("Папка ")
                    .append(homeDir.getName())
                    .append(" не существует. Создание папки " + homeDir.getName() + "\n")
                    .append(makeDir(homeDir));
        }

        for (File dir : dirs) {
            log.append(makeDir(dir));
        }

        try {
            for (File file : files) {
                log.append(makeFile(file));
            }
            String logFilePath = homeDir + "\\temp\\temp.txt";
            FileWriter fw = new FileWriter(logFilePath);
            fw.append(log);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println(log);
    }


    static LocalDateTime time = LocalDateTime.now();
    public static String makeDir(File dir) {
        return (dir.mkdir() ? "Успешное создание дирректории " + dir.getName() +" по адресу: " + dir + "  Дата и время создания: "
                + time + '\n' : "Дирректория " + dir.getName() + " уже существует, повторное создание не удалось"  + '\n');
    }

    public static String makeFile(File file) throws IOException {
        return (file.createNewFile() ? "Создание файла "+ file.getName() + " по адресу: "+ file + " Дата и время создания: "
                + time + '\n' : "Файл " + file.getName() +" уже существует, повторное создание не удалось " + '\n');
    }
}