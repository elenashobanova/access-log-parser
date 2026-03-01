import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    int totalRequests = 0;
                    int googlebotRequests = 0;
                    int yandexbotRequests = 0;

                    // Регулярное выражение для разбора строки лога
                    Pattern logPattern = Pattern.compile(
                            ("^(\\S+)\\s+(-|\\S+)\\s+(-|\\S+)\\s+\\[([^]]+)\\]\\s+\"(\\S+)\s+([^\"]+)\"\\s+(\\d+)\\s+(\\d+|-)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"$"));

                    while ((line = reader.readLine()) != null) {
                        int length = line.length();

                        // Проверяем, не превышает ли длина строки 1024 символа
                        if (length > 1024) {
                            reader.close();
                            throw new LongLineException("Обнаружена строка длиной " + length +
                                    " символов (превышает лимит 1024).");
                        }

                        totalRequests++;

                        Matcher matcher = logPattern.matcher(line);
                        if (matcher.matches()) {
                            // Извлекаем User-Agent (последняя группа в регулярном выражении)
                            String userAgent = matcher.group(10);

                            // Обрабатываем User-Agent для определения бота
                            String program = extractProgramFromUserAgent(userAgent);

                            if ("Googlebot".equals(program)) {
                                googlebotRequests++;
                            } else if ("YandexBot".equals(program)) {
                                yandexbotRequests++;
                            }
                        }
                    }

                    reader.close();

                    // Выводим результаты
                    System.out.println("\n--- Результаты анализа запросов ---");
                    System.out.println("Общее количество запросов: " + totalRequests);

                    if (totalRequests > 0) {
                        double googlebotShare = (double) googlebotRequests / totalRequests * 100;
                        double yandexbotShare = (double) yandexbotRequests / totalRequests * 100;

                        System.out.printf("Доля запросов от Googlebot: %.2f%% (%d запросов)%n",
                                googlebotShare, googlebotRequests);
                        System.out.printf("Доля запросов от YandexBot: %.2f%% (%d запросов)%n",
                                yandexbotShare, yandexbotRequests);
                    } else {
                        System.out.println("Файл не содержит запросов для анализа.");
                    }
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

    /**
     * Извлекает название программы из User-Agent согласно заданным правилам
     * @param userAgent строка User-Agent
     * @return название программы (например, "Googlebot", "YandexBot") или null, если не найдено
     */
    private static String extractProgramFromUserAgent(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) {
            return null;
        }

        // Ищем содержимое первых скобок
        int start = userAgent.indexOf('(');
        int end = userAgent.indexOf(')', start + 1);

        if (start == -1 || end == -1) {
            return null;
        }

        String firstBrackets = userAgent.substring(start + 1, end);
        String[] parts = firstBrackets.split(";");

        if (parts.length >= 2) {
            String fragment = parts[1].trim();
            // Отделяем часть до слэша
            int slashIndex = fragment.indexOf('/');
            if (slashIndex != -1) {
                return fragment.substring(0, slashIndex);
            } else {
                return fragment;
            }
        }

        return null;
    }
}

