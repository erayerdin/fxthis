package fxthis.components.system;

/**
 * <p>Helps getting information about the machine that JVM runs on.</p>
 */
public interface SystemComponent {
    /**
     * @return The operating system.
     */
    OperatingSystem getOperatingSystem();

    /**
     * @return The CPU architecture.
     */
    Architecture getArchitecture();
}
