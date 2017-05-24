package pe.thegoodone.example.demo20052017.business;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by robert on 20/05/17.
 */
public class ValidationException extends RuntimeException {

    @Getter
    private Set<ConstraintViolation<Object>> violations;

    public ValidationException(Set<ConstraintViolation<Object>> violations) {
        super("Error en validación de petición");
        this.violations = violations;
    }
}
