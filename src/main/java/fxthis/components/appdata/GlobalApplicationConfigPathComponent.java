package fxthis.components.appdata;

import com.google.inject.Inject;
import fxthis.components.meta.MetaComponent;
import fxthis.components.system.SystemComponent;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class GlobalApplicationConfigPathComponent extends ApplicationDataPathComponent {
    @Inject
    public GlobalApplicationConfigPathComponent(Logger logger, SystemComponent systemComponent, MetaComponent metaComponent) {
        super(logger, systemComponent, metaComponent);
    }

    @Override
    protected Path fetchWindowsDirectory() {
        log.fine("Fetching global config directory for Windows...");

        log.finest("Getting ProgramData environment variable...");
        final String programdata = System.getenv("ProgramData");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get(programdata, meta[0], meta[1], "config");
        log.info(String.format("Global config directory: %s", directory.toString()));
        return directory;
    }

    @Override
    protected Path fetchLinuxDirectory() {
        log.fine("Fetching global config directory for Linux...");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get("/etc", meta[0], meta[1]);
        log.info(String.format("Global config directory: %s", directory.toString()));
        return directory;
    }

    @Override
    protected Path fetchOSXDirectory() {
        log.fine("Fetching global config directory for OSX...");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get("/Library", "Application Support", meta[0], meta[1], "config");
        log.info(String.format("Global config directory: %s", directory.toString()));
        return directory;
    }

    private String[] getMetaInfo() {
        log.finest("Getting meta component info...");
        final String crName = this.metaComponent.generateComputerReadableName() == null ? "fxthisapp" : this.metaComponent.generateComputerReadableName();
        final String version = this.metaComponent.getVersionComponent().generateComputerReadableVersion();

        return new String[] {crName, version};
    }
}
