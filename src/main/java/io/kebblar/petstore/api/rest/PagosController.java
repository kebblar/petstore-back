package io.kebblar.petstore.api.rest;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.DatosOrden;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("value = pagos")
@RequestMapping(value="/api")
public class PagosController {

    @PostMapping( value = "/procesa-orden.json",
            produces = "application/json; charset=utf-8")
    public String procesaOrden(@RequestBody DatosOrden datosCompra) throws BusinessException{
        return datosCompra.toString();
    }

}
