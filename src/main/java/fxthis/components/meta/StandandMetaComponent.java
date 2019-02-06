package fxthis.components.meta;

import com.google.inject.Inject;
import fxthis.components.Component;
import fxthis.components.versioning.VersionComponent;

import java.util.logging.Logger;

// todo 2 - class doc
public class StandandMetaComponent extends Component implements MetaComponent {
    private static final String PROPERTIES_FILE = "meta.properties";

    private String humanReadableName;
    private String computerReadableName;

    @Inject private VersionComponent versionComponent;

    @Inject
    public StandandMetaComponent(Logger logger) {
        super(logger);
        this.humanReadableName = this.properties.getProperty("humanReadableName");
        this.computerReadableName = this.properties.getProperty("computerReadableName");
    }

    public String getHumanReadableName() {
        return humanReadableName;
    }

    public String getComputerReadableName() {
        return computerReadableName;
    }

    public VersionComponent getVersionComponent() {
        return versionComponent;
    }

    public String generateHumanReadableName() {
        return this.getHumanReadableName();
    }

    public String generateComputerReadableName() {
        return this.getComputerReadableName();
    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    protected String getPropertiesFilePath() {
        return PROPERTIES_FILE;
    }
}
