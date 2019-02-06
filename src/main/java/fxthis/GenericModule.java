package fxthis;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import fxthis.components.appdata.*;
import fxthis.components.appdata.types.GlobalConfig;
import fxthis.components.appdata.types.GlobalData;
import fxthis.components.appdata.types.LocalConfig;
import fxthis.components.appdata.types.LocalData;
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

        // Application Data Component
        bind(ApplicationDataPathComponent.class).annotatedWith(LocalConfig.class)
                .to(LocalApplicationConfigPathComponent.class)
                .in(Singleton.class);
        bind(ApplicationDataPathComponent.class).annotatedWith(GlobalConfig.class)
                .to(GlobalApplicationConfigPathComponent.class)
                .in(Singleton.class);
        bind(ApplicationDataPathComponent.class).annotatedWith(LocalData.class)
                .to(LocalApplicationDataPathComponent.class)
                .in(Singleton.class);
        bind(ApplicationDataPathComponent.class).annotatedWith(GlobalData.class)
                .to(GlobalApplicationDataPathComponent.class)
                .in(Singleton.class);
    }
}
