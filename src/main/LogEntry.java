package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogEntry {
    private final String ipAddress;
    private final LocalDateTime timestamp;
    private final HttpMethod httpMethod;
    private final String requestPath;
    private final int responseCode;
    private final long dataSize;
    private final String referer;
    private final UserAgent userAgent;

    // Формат даты в логах: [dd/MMM/yyyy:HH:mm:ss +0000]
    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("dd/MMM/yyyy:HH:mm:ss ")
            .appendOffset("+HHMM", "+0000")
            .toFormatter(Locale.ENGLISH);
//    private static final DateTimeFormatter DATE_FORMATTER =
//            DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    // Регулярное выражение для разбора строки лога
    private static final Pattern LOG_PATTERN = Pattern.compile(
            ("^(\\S+)\\s+(-|\\S+)\\s+(-|\\S+)\\s+\\[([^]]+)\\]\\s+\"(\\S+)\s+([^\"]+)\"\\s+(\\d+)\\s+(\\d+|-)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"$"));

    public LogEntry(String logLine) {
        Matcher matcher = LOG_PATTERN.matcher(logLine);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Некорректный формат строки лога: " + logLine);
        }

        this.ipAddress = matcher.group(1);
        String timestampStr = matcher.group(4);
        this.timestamp = LocalDateTime.parse(timestampStr, DATE_FORMATTER);

        String methodStr = matcher.group(5);
        HttpMethod method;
        try {
            method = HttpMethod.valueOf(methodStr);
        } catch (IllegalArgumentException e) {
            method = null;
        }
        this.httpMethod = method;
        this.requestPath = matcher.group(6);
        this.responseCode = Integer.parseInt(matcher.group(7));

        String dataSizeStr = matcher.group(8);
        if ("-".equals(dataSizeStr)) {
            this.dataSize = 0;
        } else {
            this.dataSize = Long.parseLong(dataSizeStr);
        }

        this.referer = matcher.group(9);
        String userAgentStr = matcher.group(10);
        this.userAgent = new UserAgent(userAgentStr);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public long getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}
