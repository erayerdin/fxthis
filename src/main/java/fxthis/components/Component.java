package fxthis.components;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

// todo 2 - class doc
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

    // todo 2 - method doc
    protected abstract String getPropertiesFilePath();
}
