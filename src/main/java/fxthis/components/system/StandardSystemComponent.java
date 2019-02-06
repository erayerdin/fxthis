package fxthis.components.system;

import com.google.inject.Inject;
import fxthis.components.Component;

import java.util.logging.Logger;

// todo 2 - class doc
public class StandardSystemComponent extends Component implements SystemComponent {
    private OperatingSystem operatingSystem;
    private Architecture architecture;

    @Inject
    public StandardSystemComponent(Logger logger) {
        super(logger);

        this.operatingSystem = this.fetchOperatingSystem();
        this.architecture = this.fetchArchitecture();
    }

    private OperatingSystem fetchOperatingSystem() {
        log.fine("Fetching operating system...");

        OperatingSystem system = null;
        final String value = System.getProperty("os.name").toLowerCase();

        if (value.contains("win"))
            system = OperatingSystem.WINDOWS;
        else if (value.contains("linux"))
            system = OperatingSystem.LINUX;
        else if (value.contains("osx"))
            system = OperatingSystem.OSX;

        if (system == null)
            log.warning("Could not detect current operating system!");
        else
            log.info(String.format("Current Operating System: %s", system.getHumanReadableName()));

        return system;
    }

    private Architecture fetchArchitecture() {
        log.fine("Fetching system architecture...");

        Architecture architecture = null;
        final String value = System.getProperty("os.arch").toLowerCase();

        if (value.contains("amd64"))
            architecture = Architecture.AMD64;
        else if (value.contains("x86"))
            architecture = Architecture.X86;
        else if (value.contains("ia64"))
            architecture = Architecture.IA64;

        if (architecture == null)
            log.warning("Could not detect current system architecture!");
        else
            log.info(String.format("Current System Architecture: %s", architecture.getHumanReadableName()));

        return architecture;
    }

    @Override
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public Architecture getArchitecture() {
        return architecture;
    }

    @Override
    protected String getPropertiesFilePath() {
        return null;
    }
}
