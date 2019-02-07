package fxthis.components.appdata.types;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A Guice binding annotation for global data directory used with ApplicationDataPathComponent.
 *
 * @see fxthis.components.appdata.ApplicationDataPathComponent
 */
@BindingAnnotation @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
public @interface GlobalData {}
