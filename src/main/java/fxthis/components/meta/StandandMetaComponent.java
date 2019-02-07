package fxthis.components.meta;

import com.google.inject.Inject;
import fxthis.components.Component;
import fxthis.components.versioning.VersionComponent;

import java.util.logging.Logger;

/**
 * <p>An implementation of MetaComponent.</p>
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
 *         <td>humanReadableName</td>
 *         <td>String</td>
 *         <td>null</td>
 *     </tr>
 *     <tr>
 *         <td>computerReadableName</td>
 *         <td>String</td>
 *         <td>null</td>
 *     </tr>
 * </table>
 *
 * @see MetaComponent
 */
public class StandandMetaComponent extends Component implements MetaComponent {
    private static final String PROPERTIES_FILE = "meta.properties";

    private String humanReadableName;
    private String computerReadableName;

    @Inject private VersionComponent versionComponent;

    @Inject
    public StandandMetaComponent(Logger logger) {
        super(logger);
        this.humanReadableName = this.properties.getProperty("humanReadableName", null);
        this.computerReadableName = this.properties.getProperty("computerReadableName", null);
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
