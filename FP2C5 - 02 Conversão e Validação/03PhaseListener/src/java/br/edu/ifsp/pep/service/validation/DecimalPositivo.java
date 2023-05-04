package br.edu.ifsp.pep.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@NotNull
@DecimalMin("0")
public @interface DecimalPositivo {

    @OverridesAttribute(constraint = DecimalMin.class, name = "message")
    String message() default "{com.algaworks.NumeroDecimal.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
