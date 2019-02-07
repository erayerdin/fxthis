package fxthis.components.appdata;

import com.google.inject.Inject;
import fxthis.components.Component;
import fxthis.components.meta.MetaComponent;
import fxthis.components.system.OperatingSystem;
import fxthis.components.system.SystemComponent;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * <p>An abstract-class for any application data/config directory.</p>
 *
 * <p>If users of fxthis cannot find the implementation they'd like to use, they can extend this
 * class.</p>
 *
 * <p>Also see implementations.</p>
 * <!-- todo whenever you add implementation, add it as @see -->
 *
 * @see Path
 *
 * <!-- Implementations -->
 * @see fxthis.components.appdata.GlobalApplicationDataPathComponent
 * @see fxthis.components.appdata.GlobalApplicationConfigPathComponent
 * @see fxthis.components.appdata.LocalApplicationDataPathComponent
 * @see fxthis.components.appdata.LocalApplicationConfigPathComponent
 */
public abstract class ApplicationDataPathComponent extends Component implements Path {
    protected Path directory;

    protected SystemComponent systemComponent;
    protected MetaComponent metaComponent;

    @Inject
    public ApplicationDataPathComponent(Logger logger, SystemComponent systemComponent, MetaComponent metaComponent) {
        super(logger);

        this.systemComponent = systemComponent;
        this.metaComponent = metaComponent;

        if (systemComponent.getOperatingSystem() == OperatingSystem.WINDOWS) {
            this.directory = this.fetchWindowsDirectory();
        } else if (systemComponent.getOperatingSystem() == OperatingSystem.LINUX) {
            this.directory = this.fetchLinuxDirectory();
        } else if (systemComponent.getOperatingSystem() == OperatingSystem.OSX) {
            this.directory = this.fetchOSXDirectory();
        }
    }

    /**
     * Gets directory for Windows.
     *
     * @return Directory for Windows
     */
    protected abstract Path fetchWindowsDirectory();

    /**
     * Gets directory for Linux.
     *
     * @return Directory for Linux
     */
    protected abstract Path fetchLinuxDirectory();

    /**
     * Gets directory for OSX.
     *
     * @return Directory for OSX
     */
    protected abstract Path fetchOSXDirectory();

    @Override
    public FileSystem getFileSystem() {
        return directory.getFileSystem();
    }

    @Override
    public boolean isAbsolute() {
        return directory.isAbsolute();
    }

    @Override
    public Path getRoot() {
        return directory.getRoot();
    }

    @Override
    public Path getFileName() {
        return directory.getFileName();
    }

    @Override
    public Path getParent() {
        return directory.getParent();
    }

    @Override
    public int getNameCount() {
        return directory.getNameCount();
    }

    @Override
    public Path getName(int index) {
        return directory.getName(index);
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        return directory.subpath(beginIndex, endIndex);
    }

    @Override
    public boolean startsWith(Path other) {
        return directory.startsWith(other);
    }

    @Override
    public boolean startsWith(String other) {
        return directory.startsWith(other);
    }

    @Override
    public boolean endsWith(Path other) {
        return directory.endsWith(other);
    }

    @Override
    public boolean endsWith(String other) {
        return directory.endsWith(other);
    }

    @Override
    public Path normalize() {
        return directory.normalize();
    }

    @Override
    public Path resolve(Path other) {
        return directory.resolve(other);
    }

    @Override
    public Path resolve(String other) {
        return directory.resolve(other);
    }

    @Override
    public Path resolveSibling(Path other) {
        return directory.resolveSibling(other);
    }

    @Override
    public Path resolveSibling(String other) {
        return directory.resolveSibling(other);
    }

    @Override
    public Path relativize(Path other) {
        return directory.relativize(other);
    }

    @Override
    public URI toUri() {
        return directory.toUri();
    }

    @Override
    public Path toAbsolutePath() {
        return directory.toAbsolutePath();
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return directory.toRealPath(options);
    }

    @Override
    public File toFile() {
        return directory.toFile();
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return directory.register(watcher, events, modifiers);
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return directory.register(watcher, events);
    }

    @Override
    public Iterator<Path> iterator() {
        return directory.iterator();
    }

    @Override
    public int compareTo(Path other) {
        return directory.compareTo(other);
    }

    @Override
    protected String getPropertiesFilePath() {
        return null;
    }
}
