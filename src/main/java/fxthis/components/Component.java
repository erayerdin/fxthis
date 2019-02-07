package fxthis.components;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <p>An abstract class to define a component. If you want to define a custom component, this is probably what
 * you want to use.</p>
 *
 * <p>A standard logger is injected to every component.</p>
 */
public abstract class Component {
    protected Properties properties;

    @Inject protected Logger log;

    @Inject
    public Component(Logger logger) {
        log = logger;

        log.info(String.format("Loading %s...", this.getClass().getSimpleName()));

        String propertiesPath = this.getPropertiesFilePath();

        if (propertiesPath != null) {
            Properties properties = new Properties();
            try {
                log.fine(String.format("Loading %s for %s...", this.getPropertiesFilePath(), this.getClass().getSimpleName()));
                properties.load(this.getClass().getClassLoader().getResourceAsStream(this.getPropertiesFilePath()));
            } catch (IOException e) {
                log.warning(String.format("Could not load %s for %s. You might get errors accessing this component. Please ensure %s exists in classpath and is fine.",
                        this.getPropertiesFilePath(), this.getClass().getSimpleName(), this.getPropertiesFilePath()));
                return;
            }

            this.properties = properties;
        }
    }

    /**
     * <p>Properties file path in classpath.</p>
     *
     * <p>Not every component needs a properties file to work. If it does not, simply return null.</p>
     *
     * @return Path to properties file in classpath.
     */
    protected abstract String getPropertiesFilePath();
}
