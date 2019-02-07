package fxthis.components.system;

/**
 * <p>The operating system that JVM runs on and fxthis recognizes.</p>
 */
public enum OperatingSystem {
    WINDOWS("Windows"),
    LINUX("GNU/Linux"),
    OSX("OSX");

    private String humanReadableName;

    OperatingSystem(String humanReadableName) {
        this.humanReadableName = humanReadableName;
    }

    public String getHumanReadableName() {
        return this.humanReadableName;
    }
}
