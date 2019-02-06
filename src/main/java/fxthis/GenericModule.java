package fxthis;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import fxthis.components.meta.MetaComponent;
import fxthis.components.meta.StandandMetaComponent;
import fxthis.components.system.StandardSystemComponent;
import fxthis.components.system.SystemComponent;
import fxthis.components.versioning.VersionComponent;
import fxthis.components.versioning.semantic.SemanticVersionComponent;

// todo 2 - class doc
public abstract class GenericModule extends AbstractModule {
    @Override
    protected void configure() {
        super.configure();

        // Meta Component
        bind(MetaComponent.class).to(StandandMetaComponent.class)
                .in(Singleton.class);

        // Versioning Component
        bind(VersionComponent.class).to(SemanticVersionComponent.class)
                .in(Singleton.class);

        // System Component
        bind(SystemComponent.class).to(StandardSystemComponent.class)
                .in(Singleton.class);
    }
}
