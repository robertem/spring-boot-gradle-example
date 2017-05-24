package pe.thegoodone.example.demo20052017.business;

import lombok.Getter;
import pe.thegoodone.example.demo20052017.model.FacturaCommand;

/**
 * Created by robert on 20/05/17.
 */
public class FacturaBusinessException extends RuntimeException {

    @Getter
    private final FacturaCommand factura;

    public FacturaBusinessException(FacturaCommand factura, String message) {
        super(message);
        this.factura = factura;
    }
}
