package fxthis.components.system;

// todo 2 - class doc
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
