/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      TestAccessHelperService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:37:24
 */
package io.kebblar.petstore.api.service;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.exceptions.PersistenceException;

//import static org.mockito.Mockito.when;
//import org.mockito.Mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import io.kebblar.petstore.api.mapper.RegistroMapper;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.utils.JwtHelper;

/**
 * <p>TestAccessHelperService class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAccessHelperService {
    private AccessHelperService accessHelperService;
    
    @Mock
    private UsuarioDetalleMapper usuarioDetalleMapper;
    
    @Mock
    private UsuarioMapper usuarioMapper;
    
    @Mock
    private RolMapper rolMapper;
    
    @Mock
    private RegistroMapper registroMapper;
    
    @Mock
    private JwtHelper jwtHelper;
    
    @Before
    public void before() {
        accessHelperService = new AccessHelperServiceImpl(
                usuarioDetalleMapper, 
                usuarioMapper, 
                rolMapper, 
                registroMapper, 
                jwtHelper);
    }
    
    private void ok() {
        assertTrue(true);                    
    }
    private void bad() {
        assertTrue(false);                    
    }
    
    @Test
    public void failedCasesTest() {
        Usuario usuario = new Usuario();
        
        // preparacion
        try {
            when(usuarioMapper.update(usuario)).thenThrow(new PersistenceException(""));
            when(usuarioMapper.insert(usuario)).thenThrow(new PersistenceException(""));            
        } catch (Exception e) {
            bad();
        }
        
        // caso 1
        try {
            accessHelperService.updateUsuario(usuario);
            bad();
        } catch (ServiceException e) { ok(); }
        
        // caso 2
        try {
            accessHelperService.insertUsuario(usuario);
            bad();
        } catch (ServiceException e) { ok(); }
        
    }
        
    @Test
    public void succeedCasesTest() {
        Usuario usuario = new Usuario();
        CredencialesRequest cred = new CredencialesRequest();
        Preregistro preRegistro = new Preregistro();
        UsuarioDetalle usuarioDetalle = new UsuarioDetalle();

        try {
            accessHelperService.createUsuario(cred);
            accessHelperService.createUsuario(usuario);
            
            accessHelperService.getByToken("");
            //accessHelperService.getCorreoFromJwt("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjIsIm1haWwiOiJndXN0YXZvLWFyZWxsYW5vQGdtYWlsLmNvbSIsInJvbGVzIjpbIm5vcm1hbCJdLCJjcmVhdGlvbiI6MTY1MTU4OTY2NjExMn0.xorkvY4LOPxoo6VzlJPhrFmEHN23r22xCfUJsFlumjE");
            accessHelperService.getPreregistroByRandomString("");
            accessHelperService.getProfilePic(0);
            accessHelperService.getProfileDesc(0);
            accessHelperService.getRegistroByMail("");
            accessHelperService.getUserRoles(0);
            accessHelperService.getUsuarioDetalle(0);
            accessHelperService.getDetallesDeUsuario(0);
            accessHelperService.getRolesDelCorreo("");
            accessHelperService.getRolesDelUsuario(0);
            accessHelperService.getTodosUsuarios();
            accessHelperService.getUsuarioByCorreo("");
            accessHelperService.getUsuarioById(0);
            
            accessHelperService.insertRegistro(preRegistro);
            accessHelperService.insertUserRol(0, 0);
            accessHelperService.insertUsuario(usuario);
            accessHelperService.insertUsuarioDetalle(usuarioDetalle);
            
            accessHelperService.updateProfileDesc(0, "", "");
            accessHelperService.updateUsuario(usuario);
            accessHelperService.updateRegistro(preRegistro);
            accessHelperService.updateUsuarioDetalle(usuarioDetalle);

            accessHelperService.deletePreregistroByRandomString("");
            accessHelperService.deleteUsuario(0);
            
            accessHelperService.confirmaRegeneraClave("","");
            accessHelperService.uploadFotoPerfil(0, "");
            accessHelperService.validateCredentialsFormat("gustavo", "arellano");
            
            assertTrue(true);
        } catch (ServiceException e) {
            assertTrue(false);
        }
    }

}
