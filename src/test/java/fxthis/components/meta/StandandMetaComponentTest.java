package fxthis.components.meta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fxthis.GenericModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandandMetaComponentTest {
    private static Injector injector;
    private MetaComponent component;

    @BeforeAll
    static void setUpClass() {
        injector = Guice.createInjector(new GenericModule() {});
    }

    @BeforeEach
    void setUp() {
        this.component = injector.getInstance(MetaComponent.class);
    }

    @Test
    void generateHumanReadableName() {
        assertEquals("My Application", this.component.generateHumanReadableName());
    }

    @Test
    void generateComputerReadableName() {
        assertEquals("my_application", this.component.generateComputerReadableName());
    }

    @Test
    void getValue() {
        assertEquals("bar", this.component.getValue("foo"));
    }
}