package pe.thegoodone.example.demo20052017.business.impl

import pe.thegoodone.example.demo20052017.business.FacturaBusinessException
import pe.thegoodone.example.demo20052017.model.FacturaCommand
import spock.lang.Specification

/**
 * Created by robert on 20/05/17.
 */
class FacturaServiceImplSpec extends Specification {

    def foo() {
        given:

        FacturaServiceImpl service = new FacturaServiceImpl()
        FacturaCommand command = new FacturaCommand(
                fecha: new Date(),
                ruc: '104641734930',
                razonSocial: 'Robert',
                montoTotal: 30,
                subTotal: 20,
                igv: 10,
                concepto: 'Consulta por servicios TI'
        )

        def factura = service.guardarFactura(command)

        expect:
        factura
    }

    def "Debería fallar al guardar una factura"() {
        when:

        FacturaServiceImpl service = new FacturaServiceImpl()
        service.guardarFactura(null)

        then:
        IllegalArgumentException error = thrown()
        error
        error.message == "La factura es requerida"
    }

    def "Debería fallar al guardar una factura con los montos incorrectos"() {
        when:

        FacturaServiceImpl service = new FacturaServiceImpl()
        FacturaCommand command = new FacturaCommand(
                fecha: new Date(),
                ruc: '104641734930',
                razonSocial: 'Robert',
                montoTotal: 30,
                subTotal: 20,
                igv: 8,
                concepto: 'Consulta por servicios TI'
        )

        service.guardarFactura(command)

        then:

        FacturaBusinessException error = thrown()
        error.message == FacturaServiceImpl.ERROR_MONTO
        error.factura
    }

}
