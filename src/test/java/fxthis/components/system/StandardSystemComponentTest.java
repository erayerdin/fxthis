package fxthis.components.system;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fxthis.GenericModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StandardSystemComponentTest {
    private static Injector injector;

    private SystemComponent component;

    @BeforeAll
    public static void setUpClass() {
        injector = Guice.createInjector(new GenericModule() {});
    }

    @BeforeEach
    public void setUp() {
        this.component = injector.getInstance(SystemComponent.class);
    }

    @Test
    void getOperatingSystem() {
        assertNotNull(this.component.getOperatingSystem());
    }

    @Test
    void getArchitecture() {
        assertNotNull(this.component.getArchitecture());
    }
}