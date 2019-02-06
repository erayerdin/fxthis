package fxthis.components.appdata;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import fxthis.GenericModule;
import fxthis.components.appdata.types.GlobalConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalApplicationConfigPathComponentTest {
    private static Injector injector;

    private ApplicationDataPathComponent component;

    @BeforeAll
    static void setUpClass() {
        injector = Guice.createInjector(new GenericModule() {});
    }

    @BeforeEach
    void setUp() {
        this.component = injector.getInstance(Key.get(ApplicationDataPathComponent.class, GlobalConfig.class));
    }

    @Test
    void isNotNull() {
        assertNotNull(this.component.directory);
    }
}