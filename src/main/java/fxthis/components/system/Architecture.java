package fxthis.components.system;

/**
 * <p>The architecture of the CPU that JVM runs on and fxthis recognizes.</p>
 */
public enum Architecture {
    X86("x86"),
    AMD64("amd64"),
    IA64("ia64");

    private String humanReadableName;

    Architecture(String humanReadableName) {
        this.humanReadableName = humanReadableName;
    }

    public String getHumanReadableName() {
        return humanReadableName;
    }
}
