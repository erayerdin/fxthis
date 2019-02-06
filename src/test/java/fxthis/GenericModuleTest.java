package fxthis;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import fxthis.components.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface CustomComponent {
    String getFoo();
}

class FooCustomComponent extends Component implements CustomComponent {
    @Inject
    public FooCustomComponent(Logger logger) {
        super(logger);
    }

    @Override
    protected String getPropertiesFilePath() {
        return null;
    }

    public String getFoo() {
        return "bar";
    }
}

class CustomModule extends GenericModule {
    @Override
    protected void configure() {
        super.configure();
        bind(CustomComponent.class).to(FooCustomComponent.class);
    }
}

class GenericModuleTest {
    private Injector injector;

    @BeforeEach
    void setUp() {
        this.injector = Guice.createInjector(new CustomModule());
    }

    @Test
    void customComponentExists() {
        CustomComponent component = this.injector.getInstance(CustomComponent.class);
        assertEquals("bar", component.getFoo());
    }
}