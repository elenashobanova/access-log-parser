import java.io.*;
import java.util.Scanner;

class LongLineException extends RuntimeException {
    public LongLineException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        int countPath = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите путь к файлу: ");
            String path = scanner.nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (fileExists && !isDirectory) {
                countPath++;
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + countPath);

                // Читаем файл и обрабатываем данные
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);

                    String line;
                    int lineCount = 0;
                    int maxLength = Integer.MIN_VALUE;
                    int minLength = Integer.MAX_VALUE;

                    while ((line = reader.readLine()) != null) {
                        int length = line.length();

                        // Проверяем, не превышает ли длина строки 1024 символа
                        if (length > 1024) {
                            reader.close();
                            throw new LongLineException("Обнаружена строка длиной " + length +
                                    " символов (превышает лимит 1024).");
                        }

                        lineCount++;
                        maxLength = Math.max(maxLength, length);
                        minLength = Math.min(minLength, length);
                    }

                    reader.close();

                    // Выводим результаты
                    System.out.println("\n--- Результаты анализа файла ---");
                    System.out.println("Общее количество строк в файле: " + lineCount);
                    System.out.println("Длина самой длинной строки: " + maxLength);
                    System.out.println("Длина самой короткой строки: " + (minLength == Integer.MAX_VALUE ? 0 : minLength));
                    System.out.println("--------------------------------");

                } catch (FileNotFoundException e) {
                    System.err.println("Файл не найден: " + e.getMessage());
                } catch (IOException e) {
                    System.err.println("Ошибка ввода‑вывода при чтении файла: " + e.getMessage());
                } catch (LongLineException e) {
                    System.err.println("Ошибка: " + e.getMessage());
                    break; // Прекращаем выполнение программы при обнаружении длинной строки
                } catch (Exception e) {
                    System.err.println("Неожиданная ошибка: ");
                    e.printStackTrace();
                }

            } else {
                if (isDirectory) {
                    System.out.println("Указанный путь является путём к папке, а не к файлу!");
                } else {
                    System.out.println("Указанный файл не существует!");
                }
            }
        }
    }
}

