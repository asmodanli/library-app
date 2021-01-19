package com.sign.demo.constraint;

import javax.validation.*;
import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,
    ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {
    String message() default "{constraints.field-match}";
    Class<?> [] groups() default {};
    Class<? extends  Payload> [] payload() default {};
    String first();
    String second();

    @Target({
            TYPE,
            ANNOTATION_TYPE
    })

    @Retention(RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }

}
