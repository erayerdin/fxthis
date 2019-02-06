package fxthis.components.meta;

import fxthis.components.versioning.VersionComponent;

// todo 2 - class doc
public interface MetaComponent {
    // todo 2 - method doc
    String generateHumanReadableName();
    // todo 2 - method doc
    String generateComputerReadableName();
    // todo 2 - method doc
    VersionComponent getVersionComponent();
    // todo 2 - method doc
    String getValue(String key);
}
