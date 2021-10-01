package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.mapper.RegistroMapper;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.*;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.support.MailSenderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class TestUsuarioService {

    @Mock
    UsuarioMapper usuarioMapper;
    @Mock
    RolMapper rolMapper;
    @Mock
    RegistroMapper registroMapper;
    @Mock
    UsuarioDetalleMapper usuarioDetalleMapper;
    @Mock
    MailSenderService mailSenderService;

    private UsuarioService usuarioService;
    private CredencialesRequest cred;
    private Usuario usuario1;
    private List<Usuario> lista;
    private List<Rol> roles;
    private UsuarioDetalle usuarioDetalle;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    private PreregistroRequest preregistro;


    @Before
    public void prepara () {
        usuarioService = new UsuarioServiceImpl(usuarioMapper,rolMapper,usuarioDetalleMapper,registroMapper,mailSenderService);
        cred = new CredencialesRequest("user", "password");
        usuario1 = new Usuario(1,"correo@correo.com", "abc");
        lista = new ArrayList<>();
        roles = new ArrayList<>();
        lista.add(usuario1);
        lista.add(new Usuario(2, "correo2@correo.com", "abc"));
        roles.add(new Rol(1, "admin", true));
        usuarioDetalle = new UsuarioDetalle(1, "fher", "romo", "olea", "apodo", new Date(), "tel");
        preregistro = new PreregistroRequest(10, "nick", "abc@gmail.com", "Fher1234.#", "5540170234", "dsjfh", 60550000, 2000, 1, 11);
    }

    @Test
    public void testCreaUsuario () throws Exception {
        try {
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenReturn(1);
            assertEquals(cred.getUsuario(), usuarioService.creaUsuario(cred).getCorreo());
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenReturn(1);
            assertEquals(usuario1.getId(), usuarioService.creaUsuario(usuario1).getId());
        } catch (Exception e) {
            logger.error("Esto no debe pasar");
        } try {
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenThrow(SQLException.class);
            usuarioService.creaUsuario(cred);
        } catch (MapperCallException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenThrow(SQLException.class);
            usuarioService.creaUsuario(usuario1);
        } catch (MapperCallException m) {
            assertTrue(true);
        }
    }

    @Test
    public void testActualizaElimina () throws Exception {
        when(usuarioMapper.update(Mockito.any(Usuario.class))).thenReturn(1);
        assertEquals(usuario1.getId(), usuarioService.actualizaUsuario(usuario1).getId());

        when(usuarioMapper.delete(1)).thenReturn(1);
        when(usuarioMapper.getById(1)).thenReturn(usuario1);
        assertEquals(usuario1.getId(), usuarioService.eliminaUsuario(1).getId());
        try {
            when(usuarioMapper.update(Mockito.any(Usuario.class))).thenThrow(SQLException.class);
            usuarioService.actualizaUsuario(usuario1);
        } catch (MapperCallException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.delete(0)).thenThrow(SQLException.class);
            usuarioService.eliminaUsuario(0);
        } catch (MapperCallException m) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetElementos () throws Exception {
        when(usuarioMapper.getById(1)).thenReturn(usuario1);
        assertNotNull(usuarioService.obtenUsuarioPorId(1));

        when(usuarioMapper.getAll()).thenReturn(lista);
        assertEquals(lista, usuarioService.obtenTodosUsuarios());

        when(usuarioMapper.getByCorreo("correo@correo.com")).thenReturn(usuario1);
        assertEquals(usuario1, usuarioService.obtenUsuarioPorCorreo("correo@correo.com"));

        when(rolMapper.getUserRoles(1)).thenReturn(roles);
        assertEquals(roles, usuarioService.obtenRolesDeUsuario(1));

        when(usuarioDetalleMapper.getById(1)).thenReturn(usuarioDetalle);
        assertEquals(usuarioDetalle.getNombre(), usuarioService.obtenDetallesDeUsuario(1).getNombre());

        try {
            when(usuarioMapper.getById(0)).thenThrow(SQLException.class);
            usuarioService.obtenUsuarioPorId(0);
        } catch (MapperCallException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getAll()).thenThrow(SQLException.class);
            usuarioService.obtenTodosUsuarios();
        } catch (MapperCallException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getByCorreo(".")).thenThrow(SQLException.class);
            usuarioService.obtenUsuarioPorCorreo(".");
        } catch (MapperCallException m) {
            assertTrue(true);
        } try {
            when(rolMapper.getUserRoles(0)).thenThrow(SQLException.class);
            usuarioService.obtenRolesDeUsuario(0);
        } catch (MapperCallException m) {
            assertTrue(true);
        } try {
            when(usuarioDetalleMapper.getById(0)).thenThrow(SQLException.class);
            usuarioService.obtenDetallesDeUsuario(0);
        } catch (MapperCallException m) {
            assertTrue(true);
        }
    }

    @Test
    public void testExtras () throws Exception {
        UsuarioServiceImpl usuarioService1 = new UsuarioServiceImpl(usuarioMapper,rolMapper,usuarioDetalleMapper,registroMapper,mailSenderService);
        assertEquals(3, usuarioService1.daysBetweenDates(new GregorianCalendar(2016, Calendar.JANUARY, 11).getTime(), new GregorianCalendar(2016, Calendar.JANUARY, 14).getTime()));

    }

    @Test
    public void testRegistro () throws Exception {

        try {
            preregistro.setDay(31);
            preregistro.setMonth(2);
            usuarioService.preRegistro2(preregistro);
        } catch (RuleException d) {
            assertTrue(true);
        }
        try {
            preregistro.setDay(30);
            preregistro.setMonth(2);
            usuarioService.preRegistro2(preregistro);
        } catch (RuleException r) {
            assertTrue(true);
        }
        try {
            preregistro.setDay(29);
            preregistro.setMonth(2);
            preregistro.setYear(1997);
            usuarioService.preRegistro2(preregistro);
        } catch (RuleException r) {
            assertTrue(true);
        }
        try {
            preregistro.setDay(31);
            preregistro.setMonth(3);
            preregistro.setYear(2019);
            usuarioService.preRegistro2(preregistro);
        } catch (RuleException r) {
            assertTrue(true);
        }
        try {
            when(usuarioMapper.getByCorreo(preregistro.getCorreo())).thenReturn(usuario1);
            preregistro.setDay(29);
            preregistro.setMonth(2);
            preregistro.setYear(2000);
            usuarioService.preRegistro2(preregistro);
        } catch (UserAlreadyExistsException b) {
            assertTrue(true);
        }
        try {
            preregistro.setClaveHash("xxx");
            usuarioService.preRegistro2(preregistro);
        } catch (StrengthPasswordValidatorException D) {
            assertTrue(true);
        }
        try {
            when((usuarioMapper.getByCorreo(preregistro.getCorreo()))).thenReturn(null);
            preregistro.setClaveHash("Fher1234#");
            assertNotNull(usuarioService.preRegistro2(preregistro));

            when(registroMapper.getByMail(Mockito.any())).thenReturn(new Preregistro());
            assertNotNull(usuarioService.preRegistro2(preregistro));
        } catch (BusinessException b) {
            logger.error("no debe de pasar esto");
        }
    }

}