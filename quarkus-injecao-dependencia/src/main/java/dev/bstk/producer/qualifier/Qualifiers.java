package dev.bstk.producer.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE})
public @interface Qualifiers {

    @interface Real { }

    @interface Euro { }

    @interface Peso { }

    @interface Dolar { }
}
