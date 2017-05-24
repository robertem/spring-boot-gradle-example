package pe.thegoodone.example.demo20052017.business.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pe.thegoodone.example.demo20052017.business.FacturaBusinessException;
import pe.thegoodone.example.demo20052017.business.FacturaService;
import pe.thegoodone.example.demo20052017.model.FacturaCommand;

import java.util.Objects;

/**
 * Created by robert on 20/05/17.
 */
@Service
public class FacturaServiceImpl implements FacturaService {

    public static final String ERROR_MONTO = "El monto total difiere del subtotal + IGV";

    @Override
    public FacturaCommand guardarFactura(FacturaCommand factura) {
        String mensaje = "La factura es requerida";

        Assert.notNull(factura, mensaje);

        if (!factura.getMontoTotal().equals(factura.getSubTotal().add(factura.getIgv()))) {
            throw new FacturaBusinessException(factura, ERROR_MONTO);
        }

        factura.setId(1L);

        return factura;
    }

}
