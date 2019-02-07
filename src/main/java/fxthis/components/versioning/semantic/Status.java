package fxthis.components.versioning.semantic;

/**
 * The status of version.
 */
public enum Status {
    SNAPSHOT("Snapshot", "snapshot"),
    PREALPHA("Prealpha", "prealpha"),
    ALPHA("Alpha", "alpha"),
    BETA("Beta", "beta"),
    STABLE("Stable", "stable");

    private String humanReadableName;
    private String computerReadableName;

    /**
     * @param humanReadableName A human-readable name of the status.
     * @param computerReadableName A computer-readable name of the status.
     */
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

    /**
     * <p>Gets status by its computer-readable name.</p>
     *
     * <p>By default, if the value is not found, it returns <code>Status.STABLE</code>.</p>
     *
     * @param value Computer-readable name of the status.
     * @return The status itself.
     */
    public static Status getStatus(String value) {
        for (Status status : Status.values()) {
            if (status.getComputerReadableName().equals(value)) {
                return status;
            }
        }

        return Status.STABLE;
    }
}
