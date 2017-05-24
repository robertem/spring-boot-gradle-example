package pe.thegoodone.example.demo20052017.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.thegoodone.example.demo20052017.business.FacturaBusinessException;
import pe.thegoodone.example.demo20052017.business.ValidationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by robert on 20/05/17.
 */
@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(FacturaBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map exc(FacturaBusinessException error) {
        Map result = new HashMap();
        result.put("factura", error.getFactura());
        result.put("mensaje", error.getMessage());

        return result;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map exc2(ValidationException error) {
        Map result = new HashMap();
        result.put("errores", new ArrayList<Object>(error.getViolations()));
        result.put("mensaje", error.getMessage());

        return result;
    }

}
