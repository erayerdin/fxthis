package fxthis;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;

// todo 2 - class doc
public abstract class GenericApplication extends Application {
    private volatile GenericModule module;
    private volatile Injector injector;

    @Override
    public void init() throws Exception {
        super.init();
        this.injector = Guice.createInjector(this.module);
    }
}
