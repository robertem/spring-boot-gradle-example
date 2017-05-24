package pe.thegoodone.example.demo20052017.business;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by robert on 20/05/17.
 */
@Service
public class ValidacionService {

    private final Validator validator;

    public ValidacionService(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object object) throws ValidationException {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);

        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }

}
