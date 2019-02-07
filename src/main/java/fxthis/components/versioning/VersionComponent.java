package fxthis.components.versioning;

/**
 * A component to help defining the version.
 */
public interface VersionComponent {
    /**
     * @return A human-readable version.
     */
    String generateHumanReadableVersion();

    /**
     * @return A computer-readable version.
     */
    String generateComputerReadableVersion();
}
