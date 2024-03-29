package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.enumerations.EnumMessage;

import static io.kebblar.petstore.api.model.enumerations.EnumMessage.*;
import io.kebblar.petstore.api.model.exceptions.*;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.support.MailSenderService;
import io.kebblar.petstore.api.support.UploadService;
import io.kebblar.petstore.api.utils.JwtHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUsuarioService {
    private UsuarioService usuarioService;
    
    @Mock
    private UploadService uploadService;
    
    @Mock
    private MailSenderService mailSenderService;
    
    @Mock
    private AccessHelperService accessHelperService;
    
    @Mock
    private JwtHelper jwtHelper;
    
    private boolean checa(ServiceException e, EnumMessage m) {
    	return m.toString().equals(e.getLocalExceptionKey());    	
    }
    
    @Test
    public void loginTest() {
        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setClave("a7cf8fe83b806ae522cafed8af7600c2b1e9f2668654c2a39cf1bef21711b945");
        usuarioService = new UsuarioServiceImpl(mailSenderService, uploadService, accessHelperService, jwtHelper);
        
        // successful login
        try {
            usuarioService.login(usuario, "Kebblar2017_", 1000, 2, 0);
            assertTrue(true);
        } catch (ServiceException e) {
            assertTrue(false);
        }
        
        // bad password, try #2
        try {
            usuarioService.login(usuario, "Kebblar", 1000, 2, 0);
            assertTrue(false);
        } catch (ServiceException e) {
            assertTrue(checa(e, BAD_CREDENTIALS));
        }
        
        // bad password, try #5
        try {
            usuario.setAccesoNegadoContador(5);
            usuarioService.login(usuario, "Kebblar", 1000, 5, 0);
            assertTrue(false);
        } catch (ServiceException e) {
            assertTrue(checa(e, MAX_FAILED_LOGIN_EXCEPTION));
        }
        
        // good password, still bloqued
        try {
            usuario.setAccesoNegadoContador(0);
            usuario.setInstanteBloqueo(1000);
            usuarioService.login(usuario, "Kebblar2017_", 1000, 5, 1000);
            assertTrue(false);
        } catch (ServiceException e) {
            assertTrue(checa(e, WAIT_LOGIN));
        }
        
        // uses doesn't exist
        try {
            usuarioService.login(null, "Kebblar2017_", 1000, 5, 1000);
            assertTrue(false);
        } catch (ServiceException e) {
            assertTrue(checa(e, BAD_CREDENTIALS));
        }  
        
        // user disabled, no matter what
        try {
            usuario.setActivo(false);
            usuarioService.login(usuario, "Kebblar2017_", 1000, 5, 1000);
            assertTrue(false);
        } catch (ServiceException e) {
            assertTrue(checa(e, DISABLED_USER));
        }        
        
    }
    
    @Test
    public void usuarioServiceTest() {
        Usuario usuario = new Usuario();
        usuario.setRegeneraClaveInstante(Long.MAX_VALUE);
        
        Preregistro preRegistro = new Preregistro();
        preRegistro.setNick("Goose");
        preRegistro.setTelefono("5587654321");
        preRegistro.setClaveHash("Kebblar2017_");
        preRegistro.setCorreo("gustavo-arellano@gmail.com");
        
        UsuarioDetalle usuarioDetalle = new UsuarioDetalle();
        Preregistro preRegistroRequest = new Preregistro();
        preRegistroRequest.setInstanteRegistro(Long.MAX_VALUE);
        preRegistroRequest.setRandomString("123456");
        preRegistroRequest.setNick("Goose");
        preRegistroRequest.setTelefono("5587654321");
        preRegistroRequest.setClaveHash("Kebblar2017_");
        preRegistroRequest.setCorreo("gustavo-arellano@gmail.com");

        usuarioService = new UsuarioServiceImpl(mailSenderService, uploadService, accessHelperService, jwtHelper);
        try {
            usuarioDetalle.setTelefonoCelular("5587654321");
            usuarioService.actualizaUsuarioDetalle(usuarioDetalle);
            
            when(accessHelperService.getUsuarioByCorreo("gustavo-arellano@gmail.com")).thenReturn(usuario);
            usuarioService.cambiaClave("gustavo-arellano@gmail.com", "Kebblar2017_");
            
            when(accessHelperService.getPreregistroByRandomString("123456")).thenReturn(preRegistroRequest);
            usuarioService.confirmaPreregistro("123456", 10);
            
            when(accessHelperService.getByToken("123456")).thenReturn(usuario);
            usuarioService.confirmaRegeneraClave("123456", "Kebblar2017_");
                        
            when(accessHelperService.getRegistroByMail("gustavo-arellano@gmail.com")).thenReturn(preRegistroRequest);
            usuarioService.preRegistro(preRegistro);
            
            usuarioService.preRegistro(preRegistroRequest);
            usuarioService.solicitaRegeneracionClave("gustavo-arellano@gmail.com");
        } catch(ServiceException be) {
            assertTrue(false);
        }
    }
/*
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
    Preregistro p;
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
        p = new Preregistro(1,"a", "abc@gmail.com", "Alphhha40#.", "5554444444", new Date(), "xxx", 231233213);
        lista.add(new Usuario(2, "correo2@correo.com", "abc"));
        roles.add(new Rol(1, "admin", true));
        usuarioDetalle = new UsuarioDetalle(1, "fher", "romo", "olea", "apodo", new Date(), "tel");
        preregistro = new PreregistroRequest(10, "nick", "abc@gmail.com", "Fher1234.#", "5540170234", "xxx", 60550000, 2000, 1, 11);
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
        } catch (MapperException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenThrow(SQLException.class);
            usuarioService.creaUsuario(usuario1);
        } catch (MapperException m) {
            assertTrue(true);
        }
    }

    @Test
    public void testActualizaElimina () {
        try {
            testActualizaElimina2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    public void testActualizaElimina2 () throws Exception {
        when(usuarioMapper.update(Mockito.any(Usuario.class))).thenReturn(1);
        assertEquals(usuario1.getId(), usuarioService.actualizaUsuario(usuario1).getId());

        when(usuarioMapper.delete(1)).thenReturn(1);
        when(usuarioMapper.getById(1)).thenReturn(usuario1);
        assertEquals(usuario1.getId(), usuarioService.eliminaUsuario(1).getId());
        try {
            when(usuarioMapper.update(Mockito.any(Usuario.class))).thenThrow(new SQLException("test"));
            usuarioService.actualizaUsuario(usuario1);
        } catch (CustomException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.delete(0)).thenThrow(SQLException.class);
            usuarioService.eliminaUsuario(0);
        } catch (MapperException m) {
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
        } catch (MapperException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getAll()).thenThrow(SQLException.class);
            usuarioService.obtenTodosUsuarios();
        } catch (MapperException m) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getByCorreo(".")).thenThrow(SQLException.class);
            usuarioService.obtenUsuarioPorCorreo(".");
        } catch (CustomException m) {
            assertTrue(true);
        } try {
            when(rolMapper.getUserRoles(0)).thenThrow(SQLException.class);
            usuarioService.obtenRolesDeUsuario(0);
        } catch (CustomException m) {
            assertTrue(true);
        } try {
            when(usuarioDetalleMapper.getById(0)).thenThrow(SQLException.class);
            usuarioService.obtenDetallesDeUsuario(0);
        } catch (CustomException m) {
            assertTrue(true);
        }
    }

    @Test
    public void testExtras() throws Exception {
        //Test metodo extra
        UsuarioServiceImpl usuarioService1 = new UsuarioServiceImpl(usuarioMapper, rolMapper, usuarioDetalleMapper, registroMapper, mailSenderService);
        assertEquals(3, usuarioService1.daysBetweenDates(new GregorianCalendar(2016, Calendar.JANUARY, 11).getTime(), new GregorianCalendar(2016, Calendar.JANUARY, 14).getTime()));
    }

    @Test
    public void testClaves() throws Exception {
        when(usuarioMapper.getByCorreo("correo@correo.com")).thenReturn(usuario1);
        assertEquals(usuario1, usuarioService.solicitaRegeneracionClave("correo@correo.com"));

        when(usuarioMapper.getByCorreo("correo@correo.com")).thenReturn(null);
        assertEquals(new Usuario(0, "err", "err"), usuarioService.solicitaRegeneracionClave("correo@correo.com"));

        try {
            when(usuarioMapper.getByCorreo("correo@correo.com")).thenThrow(SQLException.class);
            usuarioService.solicitaRegeneracionClave("correo@correo.com");
            assertEquals(new Usuario(0, "err", "err"), usuarioService.solicitaRegeneracionClave("correo@correo.com"));
        } catch (Exception e) {
            logger.error("esto no pasa");
        } try {
            when(usuarioMapper.getByToken("xxx")).thenReturn(null);
            usuarioService.confirmaRegeneraClave("xxx", "Clave1234$#");
        } catch (CustomException d) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getByToken("xxx")).thenReturn(usuario1);
            usuario1.setRegeneraClaveInstante(System.currentTimeMillis() - (60000 * 80L));
            usuarioService.confirmaRegeneraClave("xxx", "Clave12213#");
        } catch (CustomException e) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getByToken("xxx")).thenReturn(usuario1);
            when(usuarioMapper.confirmaRegeneraClave(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(1);
            usuario1.setRegeneraClaveInstante(System.currentTimeMillis()-60000);
            assertEquals(usuario1, usuarioService.confirmaRegeneraClave("xxx", "Clave1234$#"));
        } catch (CustomException t) {
            logger.error("esto no pasa");
        }
    }

    @Test
    public void testClaves2 () throws Exception {
        try {
            when(usuarioDetalleMapper.update(usuarioDetalle)).thenReturn(1);
            assertEquals(usuarioDetalle, usuarioService.actualizaUsuarioDetalle(usuarioDetalle));
        } catch (Exception e) {
            logger.error("No debe de lanzarse");
        }
        try {
            when(usuarioMapper.getByCorreo("correo@correo.com")).thenReturn(null);
            usuarioService.cambiaClave("correo@correo.com", "Hola123453$.");
        } catch (CustomException v) {
            assertTrue(true);
        } try {
            when(usuarioMapper.getByCorreo("correo@correo.com")).thenReturn(usuario1);
            assertEquals(usuario1, usuarioService.cambiaClave("correo@correo.com", "Hola123453$."));
        } catch (Exception e) {
            logger.error("no debe pasar");
        } try {
            when(usuarioMapper.getByCorreo("correo@correo.com")).thenThrow(SQLException.class);
            usuarioService.cambiaClave("correo@correo.com", "Hola123453$.");
        } catch (ServiceException d) {
            assertTrue(true);
        } try {
            when(usuarioDetalleMapper.update(usuarioDetalle)).thenThrow(SQLException.class);
            usuarioService.actualizaUsuarioDetalle(usuarioDetalle);
        } catch (MapperException d) {
            assertTrue(true);
        }
    }

    //@Test
    public void testRegistro () throws Exception {
        try {
            preregistro.setDay(31);
            preregistro.setMonth(2);
            usuarioService.preRegistro(preregistro);
        } catch (CustomException d) {
            assertTrue(true);
        }
        try {
            preregistro.setDay(30);
            preregistro.setMonth(2);
            usuarioService.preRegistro(preregistro);
        } catch (CustomException r) {
            assertTrue(true);
        }
        try {
            preregistro.setDay(29);
            preregistro.setMonth(2);
            preregistro.setYear(1997);
            usuarioService.preRegistro(preregistro);
        } catch (CustomException r) {
            assertTrue(true);
        }
        try {
            preregistro.setDay(31);
            preregistro.setMonth(3);
            preregistro.setYear(2019);
            usuarioService.preRegistro(preregistro);
        } catch (CustomException r) {
            assertTrue(true);
        }
        try {
            when(usuarioMapper.getByCorreo(preregistro.getCorreo())).thenReturn(usuario1);
            preregistro.setDay(29);
            preregistro.setMonth(2);
            preregistro.setYear(2000);
            usuarioService.preRegistro(preregistro);
        } catch (CustomException b) {
            assertTrue(true);
        }
        try {
            preregistro.setClaveHash("xxx");
            usuarioService.preRegistro(preregistro);
        } catch (CustomException D) {
            assertTrue(true);
        }
        try {
            when((usuarioMapper.getByCorreo(preregistro.getCorreo()))).thenReturn(null);
            preregistro.setClaveHash("Fher1234#");
            assertNotNull(usuarioService.preRegistro(preregistro));

            when(registroMapper.getByMail(Mockito.any())).thenReturn(new Preregistro());
            assertNotNull(usuarioService.preRegistro(preregistro));
        } catch (ServiceException b) {
            logger.error("no debe de pasar esto");
        }
        try {
            when(usuarioMapper.getByCorreo("abc@gmail.com")).thenThrow(SQLException.class);
            usuarioService.preRegistro(p);
        } catch (MapperException d) {
            assertTrue(true);
        }
    }

    @Test
    public void confirmacionTest() throws Exception {
        try {
            when(registroMapper.getByRandomString("xxx")).thenReturn(null);
            usuarioService.confirmaPreregistro("xxx");
        }catch (CustomException t) {
            assertTrue(true);
        } try {
            when(registroMapper.getByRandomString("454")).thenThrow(SQLException.class);
            usuarioService.confirmaPreregistro("454");
        } catch (ServiceException b) {
            assertTrue(true);
        } try {
            when(registroMapper.getByRandomString("xxx")).thenReturn(p);
            p.setInstanteRegistro(800);
            usuarioService.confirmaPreregistro("xxx");
        } catch (CustomException t) {
            assertTrue(true);
        } try {
            when(registroMapper.getByRandomString("xx")).thenReturn(p);
            p.setInstanteRegistro(System.currentTimeMillis()-60000);
            usuarioService.confirmaPreregistro("xx");
        } catch (CustomException t) {
            assertTrue(true);
        } try {
            when(registroMapper.getByRandomString("xxx")).thenReturn(p);
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenThrow(SQLException.class);
            usuarioService.confirmaPreregistro("xxx");
        } catch (TransactionException t) {
            assertTrue(true);
        } try {
            when(usuarioMapper.insert(Mockito.any(Usuario.class))).thenReturn(1);
            when(usuarioDetalleMapper.insert(Mockito.any(UsuarioDetalle.class))).thenReturn(1);
            when(rolMapper.insertUserRol(0,2)).thenReturn(1);
            when(registroMapper.deleteByRandomString("xxx")).thenReturn(1);
            usuarioService.confirmaPreregistro("xxx");
        } catch (TransactionException t) {
            logger.info("esto no pasa");
        }
    }
*/
    
    
/*
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private JwtManagerService jwtManagerService;

    private Usuario usuario = new Usuario(
            1, "gustavo_arellano@gmail.com",
            "399a89d772ebdc27d7dff05af2877b58f87c3a04086cd32db71bcd3b2c1dc5c4",
            1875437L, true, 3, 0, 0, 0, "regenra-clave-token", 0);


    @Before
    public void prepara() {
        when(jwtManagerService.createToken(Mockito.any())).thenReturn("token-bxcdhjbshjc7382gyd");
        this.usuarioService = new UsuarioServiceImpl(usuarioService, jwtManagerService);
    }

 
    @Test
    public void loginOkTest() {
        try {
            when(usuarioService.obtenUsuarioPorCorreo(usuario.getCorreo())).thenReturn(usuario);
            LoginResponse response = this.usuarioService.login(
                    "gustavo_arellano@gmail.com",
                    "Kebblar2017");
            System.out.println(response);
            assert(true);
        } catch (ServiceException e) {
            assert(false);
        }
    }
    @Test
    public void revienta() {
        assert(true);
    }

    @Test
    public void loginBadTest() {
        this.usuario.setAccesoNegadoContador(2);
        try {
            when(usuarioService.obtenUsuarioPorCorreo(usuario.getCorreo())).thenReturn(usuario);
            this.usuarioService.login(
                    "gustavo_arellano@gmail.com",
                    "Kebblar2017_");
            assert(false);
        } catch (ServiceException e) {
            assert(true);
        }
    }

    @Test
    public void loginBadUserTest() {
        this.usuario.setAccesoNegadoContador(2);
        try {
            when(usuarioService.obtenUsuarioPorCorreo("xgustavo_arellano@gmail.com")).thenReturn(null);
            this.usuarioService.login(
                    "xgustavo_arellano@gmail.com",
                    "Kebblar2017_");
            assert(false);
        } catch (ServiceException e) {
            assert(true);
        }
    }

    @Test
    public void login2OkUserTest() {
        this.usuario.setAccesoNegadoContador(5);
        long tiempo = System.currentTimeMillis()-2*60*1000+ 1234;
        this.usuario.setInstanteBloqueo(tiempo);
        try {
            this.usuarioService.login(usuario, "Kebblar2017", 5*60*1000, 4, System.currentTimeMillis());
            assert(false);
        } catch (ServiceException e) {
            assert(true);
        }
    }

    @Test
    public void loginVeryBadTest() {
        this.usuario.setAccesoNegadoContador(5);
        try {
            when(usuarioService.obtenUsuarioPorCorreo(usuario.getCorreo())).thenReturn(usuario);
            this.usuarioService.login(
                    "gustavo_arellano@gmail.com",
                    "Kebblar2017_");
            assert(false);
        } catch (ServiceException e) {
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
    */    
}
