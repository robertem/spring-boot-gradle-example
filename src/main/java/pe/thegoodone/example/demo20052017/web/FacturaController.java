package pe.thegoodone.example.demo20052017.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.thegoodone.example.demo20052017.business.FacturaService;
import pe.thegoodone.example.demo20052017.business.ValidacionService;
import pe.thegoodone.example.demo20052017.model.FacturaCommand;

/**
 * Created by robert on 20/05/17.
 */
@RestController
@RequestMapping("/v1/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ValidacionService validacionService;

    @PostMapping
    public ResponseEntity<FacturaCommand> guardar(@RequestBody FacturaCommand command) {

        /*
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Error en validación de datos");
        }
        */

        validacionService.validate(command);

        FacturaCommand factura = facturaService.guardarFactura(command);

        return new ResponseEntity<FacturaCommand>(factura, HttpStatus.CREATED);
    }

}
