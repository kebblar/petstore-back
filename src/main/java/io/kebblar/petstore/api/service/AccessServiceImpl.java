package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.UserAlreadyExistsException;
import io.kebblar.petstore.api.model.response.LoginResponse;

@Service
public class AccessServiceImpl implements AccessService {
    @Value("${proyecto.message2}")
    private String message;

    @Override
    public LoginResponse login(String usuario, String clave) throws BusinessException {
        System.out.println("**************************************>"+message);

        if(clave.length()<3) throw new UserAlreadyExistsException();
        UsuarioDetalle ud = new UsuarioDetalle(7,"Miguel", "Hidalgo");
        List<Rol> roles = new ArrayList<>();
        Rol r1 = new Rol(1, "abc1", true);
        Rol r2 = new Rol(2, "abc2", true);
        Rol r3 = new Rol(3, "abc3", true);
        Rol r4 = new Rol(4, "abc4", true);
        roles.add(r1);
        roles.add(r2);
        roles.add(r3);
        roles.add(r4);


        List<Direccion> direcciones = new ArrayList<>();
        Direccion d1 = new Direccion(1, "calle 1", "col 1", 1, 1);
        Direccion d2 = new Direccion(2, "calle 2", "col 2", 2, 2);
        Direccion d3 = new Direccion(3, "calle 3", "col 3", 3, 3);
        direcciones.add(d1);
        direcciones.add(d2);
        direcciones.add(d3);


        return new LoginResponse(ud, new Date(), "gus@aol.com", "jwt-bchfjdbchfd", roles, direcciones);
    }

}
