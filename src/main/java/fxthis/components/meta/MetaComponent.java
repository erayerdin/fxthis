package fxthis.components.meta;

import fxthis.components.versioning.VersionComponent;

/**
 * <p>Helps getting application's meta data.</p>
 */
public interface MetaComponent {
    /**
     * @return Human-readable name of the application.
     */
    String generateHumanReadableName();

    /**
     * @return Computer-readable name of the application.
     */
    String generateComputerReadableName();

    /**
     * @see VersionComponent
     * @return Version component.
     */
    VersionComponent getVersionComponent();

    /**
     * @param key A key to get.
     * @return Another custom value based on the key.
     */
    String getValue(String key);
}
