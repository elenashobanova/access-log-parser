package main;

public class UserAgent {
    private final String osType;
    private final String browserType;

    public UserAgent(String userAgentString) {
        this.osType = extractOSType(userAgentString);
        this.browserType = extractBrowserType(userAgentString);
    }

    private String extractOSType(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) return "Unknown";

        if (userAgent.contains("Windows")) return "Windows";
        if (userAgent.contains("macOS") || userAgent.contains("Macintosh")) return "macOS";
        if (userAgent.contains("Linux")) return "Linux";
        return "Unknown";
    }

    private String extractBrowserType(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) return "Unknown";

        if (userAgent.contains("Edge")) return "Edge";
        if (userAgent.contains("Firefox")) return "Firefox";
        if (userAgent.contains("Chrome")) return "Chrome";
        if (userAgent.contains("Opera")) return "Opera";
        return "Other";
    }

    public String getOsType() {
        return osType;
    }

    public String getBrowserType() {
        return browserType;
    }
}
