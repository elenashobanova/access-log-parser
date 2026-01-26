import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countPath = 0;
        while (true) {
            System.out.println("Введите путь к файлу");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (fileExists && !isDirectory) {
                countPath++;
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + countPath);
                continue;
            }
            if (isDirectory)
                System.out.println("Указанный путь является путём к папке, а не к файлу");
            else
                System.out.println("Указанный файл не существует");
        }
    }
 }

