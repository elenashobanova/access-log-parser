package main;

import java.time.LocalDateTime;

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
}
