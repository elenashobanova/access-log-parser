import main.LogEntry;
import main.Statistics;
import main.UserAgent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics();
        List<LogEntry> logEntries = new ArrayList<>();

        // Пример строк лога для тестирования
        String[] logLines = {
                "192.168.1.100 - - [24/Oct/2023:14:20:15 +0000] \"POST /api/data\" 201 1250 \"\" \"Mozilla/5.0 (macOS; Intel Mac OS X 10_15_7) Firefox/119.0\"",
                "88.12.45.77 - - [24/Oct/2023:15:30:45 +0000] \"GET /about.html\" 200 3200 \"https://example.com\" \"Mozilla/5.0 (Linux; Android 10) Opera/72.0\"",
                "203.0.113.1 - - [24/Oct/2023:16:10:30 +0000] \"GET /contact.html\" 404 512 \"\" \"Googlebot/2.1 (+http://www.google.com/bot.html)\""
        };

        System.out.println("=== Анализ лог‑файла ===");

        try {
            // Создаём объекты LogEntry из строк лога
            for (String logLine : logLines) {
                LogEntry entry = new LogEntry(logLine);
                logEntries.add(entry);

                // Добавляем запись в статистику
                stats.addEntry(entry);

                // Выводим информацию о каждой записи
                System.out.printf("IP: %s, Время: %s, Метод: %s, Путь: %s%n",
                        entry.getIpAddress(),
                        entry.getTimestamp().format(java.time.format.DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss")),
                        entry.getHttpMethod(),
                        entry.getRequestPath());

                UserAgent userAgent = entry.getUserAgent();
                System.out.printf("  OS: %s, Браузер: %s, Размер: %d байт%n",
                        userAgent.getOsType(),
                        userAgent.getBrowserType(),
                        entry.getDataSize());
                System.out.println();
            }

            // Выводим итоговую статистику
            System.out.println("=== Итоговая статистика ===");
            System.out.printf("Общее количество записей: %d%n", logEntries.size());
            System.out.printf("Общий объём трафика: %d байт%n", stats.totalTraffic);

            if (stats.minTime != null && stats.maxTime != null) {
                System.out.printf("Период анализа: с %s до %s%n",
                        stats.minTime.format(java.time.format.DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm")),
                        stats.maxTime.format(java.time.format.DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm")));

                double trafficRate = stats.getTrafficRate();
                System.out.printf("Средний трафик за час: %.2f байт/час%n", trafficRate);
            } else {
                System.out.println("Недостаточно данных для расчёта трафика.");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при обработке лога: " + e.getMessage());
        }
    }
}

