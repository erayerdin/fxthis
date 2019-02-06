package fxthis.components.versioning.semantic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fxthis.GenericModule;
import fxthis.components.versioning.VersionComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SemanticVersionComponentTest {
    private static Injector injector;
    private VersionComponent component;

    @BeforeAll
    static void setUpClass() {
        injector = Guice.createInjector(new GenericModule() {});
    }

    @BeforeEach
    void setUp() {
        this.component = injector.getInstance(VersionComponent.class);
    }

    @Test
    void generateHumanReadableVersion() {
        assertEquals("0.1.0 Beta", this.component.generateHumanReadableVersion());
    }

    @Test
    void generateComputerReadableVersion() {
        assertEquals("0.1.0-beta", this.component.generateComputerReadableVersion());
    }
}