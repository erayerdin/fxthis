package fxthis.components.versioning.semantic;

import com.google.inject.Inject;
import fxthis.components.Component;
import fxthis.components.versioning.VersionComponent;

import java.util.logging.Logger;

/**
 * <p>An implementation of VersionComponent.</p>
 *
 * <p>This implementation uses <code>meta.properties</code> file in the classpath in order to get various
 * information about application. <code>meta.properties</code> needs to have the keys below:</p>
 *
 * <table>
 *     <tr>
 *         <th>Property Name</th>
 *         <th>Property Type</th>
 *         <th>Assigned Default Value</th>
 *     </tr>
 *     <tr>
 *         <td>majorVersion</td>
 *         <td>int</td>
 *         <td>0</td>
 *     </tr>
 *     <tr>
 *         <td>minorVersion</td>
 *         <td>int</td>
 *         <td>1</td>
 *     </tr>
 *     <tr>
 *         <td>patchVersion</td>
 *         <td>int</td>
 *         <td>0</td>
 *     </tr>
 *     <tr>
 *         <td>status</td>
 *         <td>String</td>
 *         <td>stable</td>
 *     </tr>
 * </table>
 *
 * @see VersionComponent
 */
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
        this.majorNumber = Integer.parseInt(this.properties.getProperty("majorVersion", "0"));
        this.minorNumber = Integer.parseInt(this.properties.getProperty("minorVersion", "1"));
        this.patchNumber = Integer.parseInt(properties.getProperty("patchVersion", "0"));

        this.status = Status.getStatus(properties.getProperty("status", "stable").toLowerCase());
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
