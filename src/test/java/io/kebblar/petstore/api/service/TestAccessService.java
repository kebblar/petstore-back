package io.kebblar.petstore.api.service;

import static org.mockito.Mockito.when;

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
    
}
