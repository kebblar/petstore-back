package io.kebblar.petstore.api.service;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.support.JwtManagerService;

@RunWith(MockitoJUnitRunner.class)
public class TestAccessService {
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private JwtManagerService jwtManagerService;

    private AccessService accessService = null;

    private Usuario usuario = new Usuario(
            1, "gustavo_arellano@gmail.com",
            "399a89d772ebdc27d7dff05af2877b58f87c3a04086cd32db71bcd3b2c1dc5c4",
            1875437L, true, 3, 0, 0, 0, "regenra-clave-token", 0);

    @Before
    public void prepara() {
        when(jwtManagerService.createToken(Mockito.any())).thenReturn("token-bxcdhjbshjc7382gyd");
        this.accessService = new AccessServiceImpl(usuarioService, jwtManagerService);
    }

    @Test
    public void loginOkTest() {
        try {
            when(usuarioService.obtenUsuarioPorCorreo(usuario.getCorreo())).thenReturn(usuario);
            LoginResponse response = this.accessService.login(
                    "gustavo_arellano@gmail.com",
                    "Kebblar2017");
            System.out.println(response);
            assert(true);
        } catch (BusinessException e) {
            assert(false);
        }
    }

    /**
     * Con 2 intentos previos fallidos, se trata de ingresar
     * con un usuario existente pero con una clave incorrecta.
     */
    @Test
    public void loginBadTest() {
        this.usuario.setAccesoNegadoContador(2);
        try {
            when(usuarioService.obtenUsuarioPorCorreo(usuario.getCorreo())).thenReturn(usuario);
            this.accessService.login(
                    "gustavo_arellano@gmail.com",
                    "Kebblar2017_");
            assert(false);
        } catch (BusinessException e) {
            assert(true);
        }
    }

    /**
     * Se trata de ingresar con un usuario NO
     * existente pero con una clave cualquiera.
     */
    @Test
    public void loginBadUserTest() {
        this.usuario.setAccesoNegadoContador(2);
        try {
            when(usuarioService.obtenUsuarioPorCorreo("xgustavo_arellano@gmail.com")).thenReturn(null);
            this.accessService.login(
                    "xgustavo_arellano@gmail.com",
                    "Kebblar2017_");
            assert(false);
        } catch (BusinessException e) {
            assert(true);
        }
    }

    @Test
    public void login2OkUserTest() {
        this.usuario.setAccesoNegadoContador(5);
        long tiempo = System.currentTimeMillis()-2*60*1000+ 1234;
        this.usuario.setInstanteBloqueo(tiempo);
        try {
            this.accessService.login(usuario, "Kebblar2017", 5*60*1000, 4, System.currentTimeMillis());
            assert(false);
        } catch (BusinessException e) {
            assert(true);
        }
    }

    @Test
    public void loginVeryBadTest() {
        this.usuario.setAccesoNegadoContador(5);
        try {
            when(usuarioService.obtenUsuarioPorCorreo(usuario.getCorreo())).thenReturn(usuario);
            this.accessService.login(
                    "gustavo_arellano@gmail.com",
                    "Kebblar2017_");
            assert(false);
        } catch (BusinessException e) {
            assert(true);
        }
    }
    @Test
    public void DateTest() {
        long oneday = 1000*60*60*24;
        long oneYear = oneday*365;
        Date origen = new Date(0); //Wed Dec 31 18:00:00 CST 1969
        long gus = -83495789067L+oneday*165; // Sun Oct 22 08:43:30 CST 1967 // -69239789067
        Date cumple = new Date(gus);
        long x = origen.getTime();
        long now = System.currentTimeMillis();
        long year1967 = now - oneYear*54;
        Date d = new Date(year1967); // -83495789067 // Wed May 10 08:43:30 CST 1967
        System.out.println(d);
        System.out.println(cumple);

        System.out.println(origen);
        System.out.println(x);
        assert(year1967!=0);
    }
}
