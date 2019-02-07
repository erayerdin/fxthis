package fxthis.components.appdata;

import com.google.inject.Inject;
import fxthis.components.meta.MetaComponent;
import fxthis.components.system.SystemComponent;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * <p>An implementation of ApplicationDataPathComponent.</p>
 *
 * <p>Configures Global Application Data Path. This path is meant to be for your application's data
 * files. Depending on the operating system, it will possess the directories below:</p>
 *
 * <ul>
 *     <li><strong>Windows:</strong> <code>C:\ProgramData\[appname]\[appversion]\data</code></li>
 *     <li><strong>Linux:</strong> <code>/usr/share/[appname]/[appversion]</code></li>
 *     <li><strong>OSX:</strong> <code>/Library/Application Support/[appname]/[appversion]/data</code></li>
 * </ul>
 *
 * @see ApplicationDataPathComponent
 */
public class GlobalApplicationDataPathComponent extends ApplicationDataPathComponent {
    @Inject
    public GlobalApplicationDataPathComponent(Logger logger, SystemComponent systemComponent, MetaComponent metaComponent) {
        super(logger, systemComponent, metaComponent);
    }

    @Override
    protected Path fetchWindowsDirectory() {
        log.fine("Fetching global data directory for Windows...");

        log.finest("Getting ProgramData environment variable...");
        final String programdata = System.getenv("ProgramData");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get(programdata, meta[0], meta[1], "data");
        log.info(String.format("Global data directory: %s", directory.toString()));
        return directory;
    }

    @Override
    protected Path fetchLinuxDirectory() {
        log.fine("Fetching global data directory for Linux...");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get("/usr", "share", meta[0], meta[1]);
        log.info(String.format("Global data directory: %s", directory.toString()));
        return directory;
    }

    @Override
    protected Path fetchOSXDirectory() {
        log.fine("Fetching global data directory for OSX...");

        String[] meta = this.getMetaInfo();

        Path directory = Paths.get("/Library", "Application Support", meta[0], meta[1], "data");
        log.info(String.format("Global data directory: %s", directory.toString()));
        return directory;
    }

    private String[] getMetaInfo() {
        log.finest("Getting meta component info...");
        final String crName = this.metaComponent.generateComputerReadableName() == null ? "fxthisapp" : this.metaComponent.generateComputerReadableName();
        final String version = this.metaComponent.getVersionComponent().generateComputerReadableVersion();

        return new String[] {crName, version};
    }
}
