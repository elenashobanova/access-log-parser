package main;

import java.time.LocalDateTime;
import java.util.*;

public class Statistics {
    public int totalTraffic;
    public LocalDateTime minTime;
    public LocalDateTime maxTime;

    public Statistics() {
        this.totalTraffic = 0;
        this.minTime = null;
        this.maxTime = null;
    }

    public void addEntry(LogEntry entry) {
        totalTraffic += entry.getDataSize();

        LocalDateTime entryTime = entry.getTimestamp();
        if (minTime == null || entryTime.isBefore(minTime)) {
            minTime = entryTime;
        }
        if (maxTime == null || entryTime.isAfter(maxTime)) {
            maxTime = entryTime;
        }
    }

    /**
     * Вычисляет средний объём трафика за час
     *
     * @return средний трафик за час в байтах, или 0, если данных недостаточно
     */
    public double getTrafficRate() {
        if (minTime == null || maxTime == null) {
            return 0.0;
        }

        long hoursDiff = java.time.Duration.between(minTime, maxTime).toHours();
        if (hoursDiff == 0) {
            // Если все записи сделаны в течение одного часа
            hoursDiff = 1;
        }

        return (double) totalTraffic / hoursDiff;
    }

    // HashSet для хранения уникальных страниц с кодом ответа 200
    private final Set<String> existingPages = new HashSet<>();

    // HashMap для подсчёта частоты встречаемости операционных систем
    private final Map<String, Integer> osFrequency = new HashMap<>();

    public void addEntry(String page, int responseCode, String operatingSystem) {
        // Добавляем страницу в HashSet только если код ответа 200 (успешный)
        if (responseCode == 200) {
            existingPages.add(page);
        }

        // Обновляем счётчик для операционной системы
        if (osFrequency.containsKey(operatingSystem)) {
            // Если ОС уже есть в HashMap, увеличиваем счётчик на 1
            int currentCount = osFrequency.get(operatingSystem);
            osFrequency.put(operatingSystem, currentCount + 1);
        } else {
            // Если ОС нет в HashMap, добавляем с начальным значением 1
            osFrequency.put(operatingSystem, 1);
        }
    }


    public List<String> getAllPages() {
        return new ArrayList<>(existingPages);
    }

    public Map<String, Double> getOsStatistics() {
        Map<String, Double> osShares = new HashMap<>();

        // Вычисляем общее количество записей операционных систем
        int totalOsCount = 0;
        for (int count : osFrequency.values()) {
            totalOsCount += count;
        }

        // Если данных нет, возвращаем пустой HashMap
        if (totalOsCount == 0) {
            return osShares;
        }

        // Рассчитываем долю для каждой операционной системы
        for (Map.Entry<String, Integer> entry : osFrequency.entrySet()) {
            String os = entry.getKey();
            int osCount = entry.getValue();
            double share = (double) osCount / totalOsCount;
            osShares.put(os, share);
        }

        return osShares;
    }
}

