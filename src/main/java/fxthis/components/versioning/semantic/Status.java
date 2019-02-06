package fxthis.components.versioning.semantic;

// todo 2 - class doc
public enum Status {
    SNAPSHOT("Snapshot", "snapshot"),
    PREALPHA("Prealpha", "prealpha"),
    ALPHA("Alpha", "alpha"),
    BETA("Beta", "beta"),
    STABLE("Stable", "stable");

    private String humanReadableName;
    private String computerReadableName;

    Status(String humanReadableName, String computerReadableName) {
        this.humanReadableName = humanReadableName;
        this.computerReadableName = computerReadableName;
    }

    protected String getHumanReadableName() {
        return humanReadableName;
    }

    protected String getComputerReadableName() {
        return computerReadableName;
    }

    // todo 2 - method doc
    public static Status getStatus(String value) {
        for (Status status : Status.values()) {
            if (status.getComputerReadableName().equals(value)) {
                return status;
            }
        }

        return Status.STABLE;
    }
}
