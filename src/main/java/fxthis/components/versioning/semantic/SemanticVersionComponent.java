package fxthis.components.versioning.semantic;

import com.google.inject.Inject;
import fxthis.components.Component;
import fxthis.components.versioning.VersionComponent;

import java.util.logging.Logger;

public class SemanticVersionComponent extends Component implements VersionComponent {
    private static final String PROPERTIES_FILE = "meta.properties";

    private int majorNumber;
    private int minorNumber;
    private int patchNumber;
    private Status status;

    public Logger log;

    @Inject
    public SemanticVersionComponent(Logger logger) {
        super(logger);
        this.majorNumber = Integer.parseInt(this.properties.getProperty("majorVersion"));
        this.minorNumber = Integer.parseInt(this.properties.getProperty("minorVersion"));
        this.patchNumber = Integer.parseInt(properties.getProperty("patchVersion"));

        this.status = Status.getStatus(properties.getProperty("status"));
    }

    public int getMajorNumber() {
        return majorNumber;
    }

    public int getMinorNumber() {
        return minorNumber;
    }

    public int getPatchNumber() {
        return patchNumber;
    }

    public Status getStatus() {
        return status;
    }

    public String generateHumanReadableVersion() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.majorNumber);
        builder.append('.');
        builder.append(this.minorNumber);
        builder.append('.');
        builder.append(this.patchNumber);

        if (this.status != null && this.status != Status.STABLE) {
            builder.append(' ');
            builder.append(this.status.getHumanReadableName());
        }

        return builder.toString();
    }

    public String generateComputerReadableVersion() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.majorNumber);
        builder.append('.');
        builder.append(this.minorNumber);
        builder.append('.');
        builder.append(this.patchNumber);

        if (status != null && this.status != Status.STABLE) {
            builder.append('-');
            builder.append(this.status.getComputerReadableName());
        }

        return builder.toString();
    }

    protected String getPropertiesFilePath() {
        return PROPERTIES_FILE;
    }
}
