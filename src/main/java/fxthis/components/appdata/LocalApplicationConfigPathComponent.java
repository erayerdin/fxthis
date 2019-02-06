package fxthis.components.appdata;

import com.google.inject.Inject;
import fxthis.components.meta.MetaComponent;
import fxthis.components.system.SystemComponent;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

// todo 2 - class doc
public class LocalApplicationConfigPathComponent extends ApplicationDataPathComponent {
    @Inject
    public LocalApplicationConfigPathComponent(Logger logger, SystemComponent systemComponent, MetaComponent metaComponent) {
        super(logger, systemComponent, metaComponent);
    }

    protected Path fetchWindowsDirectory() {
        log.fine("Fetching local config directory for Windows...");

        log.finest("Getting APPDATA environment variable...");
        final String appdata = System.getenv("APPDATA");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get(appdata, meta[0], meta[1], "config");
        log.info(String.format("Local config directory: %s", directory.toString()));
        return directory;
    }

    protected Path fetchLinuxDirectory() {
        log.fine("Fetching local config directory for Linux...");

        log.finest("Getting HOME environment variable...");
        final String home = System.getenv("HOME");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get(home, ".config", meta[0], meta[1]);
        log.info(String.format("Local config directory: %s", directory.toString()));
        return directory;
    }

    protected Path fetchOSXDirectory() {
        // based on info at harawata's appdirs
        // see: https://github.com/harawata/appdirs#output-on-mac-os-x-username--ave
        log.fine("Fetching local config directory for OSX...");

        log.finest("Getting USER environment variable...");
        final String username = System.getenv("USER");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get("/Users", username, "Application Support", meta[0], meta[1], "config");
        log.info(String.format("Local config directory: %s", directory.toString()));
        return directory;
    }

    private String[] getMetaInfo() {
        log.finest("Getting meta component info...");
        final String crName = this.metaComponent.generateComputerReadableName() == null ? "fxthisapp" : this.metaComponent.generateComputerReadableName();
        final String version = this.metaComponent.getVersionComponent().generateComputerReadableVersion();

        return new String[] {crName, version};
    }
}
