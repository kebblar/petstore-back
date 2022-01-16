/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AccessController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:22:06
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioCompleto;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.enumerations.EnumMessage;
import io.kebblar.petstore.api.model.request.ConsultaRequest;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.DescripcionRequest;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.model.response.ConsultaResponse;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.service.AccessHelperService;
import io.kebblar.petstore.api.service.ConsultaService;
import io.kebblar.petstore.api.service.UsuarioCompletoService;
import io.kebblar.petstore.api.service.UsuarioService;
import io.kebblar.petstore.api.support.InvokeRemoteRestService;
import io.kebblar.petstore.api.utils.JWTUtil;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.exceptions.CustomException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Implementacion  del controlador REST asociado a los endpoints
 * de gestión del AccessController.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}</p>
 *
 * <p>NOTA IMPORTANTE: Los  distintos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.</p>
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.UsuarioDetalle
 * @see     io.kebblar.petstore.api.model.request.CredencialesRequest
 * @see     io.kebblar.petstore.api.service.AccessService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class AccessController {
    private final ConsultaService consultaService;
    private final UsuarioService usuarioService;
    private final AccessHelperService accessHelperService;
    private final InvokeRemoteRestService invokeRestService;
    private final UsuarioCompletoService usuarioCompletoService;
    private final JWTUtil jwtInstance;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param accessService Servicios de AccessService
     */
    public AccessController(
            AccessHelperService accessHelperService,
            UsuarioService usuarioService,
            InvokeRemoteRestService invokeRestService,
            UsuarioCompletoService usuarioCompletoService,
            ConsultaService consultaService) {
        this.usuarioService = usuarioService;
        this.invokeRestService = invokeRestService;
        this.usuarioCompletoService = usuarioCompletoService;
        this.consultaService = consultaService;
        this.accessHelperService = accessHelperService;
        this.jwtInstance = JWTUtil.getInstance();
    }

    @ApiOperation(
            value = "AccessController::login",
            notes = "Recibe las credenciales de inicio de sesión y las valida," +
                    "en caso de ser incorrectas, regresa un ControllerException.")
    @PostMapping(
            path = "/login",
            produces = "application/json; charset=utf-8")
    public LoginResponse login(
            @ApiParam(name="cred", value="Representa las credenciales (usuario y clave) " +
                    "de quien intenta ingresar al sistema")
            @RequestBody CredencialesRequest cred) throws ControllerException {
        return usuarioService.login(cred.getUsuario(), cred.getClave());
    }

    @ApiOperation(
            value = "AccessController::UsuarioPreregistro",
            notes = "Recibe la información de registro de un nuevo usuario al sistema.")
    @PostMapping(
            path = "/usuario-preregistro",
            produces = "application/json; charset=utf-8")
    public Preregistro preRegistro(
            @ApiParam(name = "dato", value = "Información con el detalle de un Usuario")
            @RequestBody Preregistro preRegistro) throws ControllerException {
        return this.usuarioService.preRegistro(preRegistro);
    }

    @ApiOperation(
            value = "AccessController::?",
            notes = "Mismo de arriba?")
    @PostMapping(
            path = "/usuario-preregistro2",
            produces = "application/json; charset=utf-8")
    public Preregistro preRegistro2(
            @ApiParam(name = "preRegistroRequest", value = "Información con el detalle de un Usuario")
            @RequestBody @Valid PreregistroRequest preRegistroRequest) throws ControllerException {
        return this.usuarioService.preRegistro(preRegistroRequest);
    }

    @ApiOperation(
            value = "RegistroController::VerificarCaptcha",
            notes = "Verifica que el Google captcha V 2.0 sea correcto")
    @PostMapping(
            value = "/check-captcha",
            produces = "application/json; charset=utf-8")
    public String checkCaptcha(
            @ApiParam(name = "googleCaptcha", value = "Google Captcha V2.0")
            @RequestBody GoogleCaptcha googleCaptcha) throws ControllerException {
        return invokeRestService.checkCaptcha(googleCaptcha);
    }

    @ApiOperation(
            value = "AccessController::ConfirmaPreregistro",
            notes = "Valida un registro por medio de un token que el sistema envía" +
                    "al usuario por correo electrónico para confirmar que este ultimo" +
                    "existe.")
    @GetMapping(
            path = "/confirma-preregistro",
            produces = "application/json; charset=utf-8")
    public Usuario confirmaPreregistro(
            @ApiParam(name = "token", value = "Token de confirmación del registro enviado por correo")
            @RequestParam String token) throws ControllerException {
        return usuarioService.confirmaPreregistro(token);
    }

    @ApiOperation(
            value = "AccessController::RegeneraClave",
            notes = "Recibido el correo de un usuario que desea recuperar su clave de acceso," +
                    "el sistema internamente le envía un token de recuperación a su correo" +
                    "electrónico.")
    @GetMapping(
            path = "/regenera-clave",
            produces = "application/json; charset=utf-8")
    public Usuario regeneraClave(
            @ApiParam(name = "correo", value = "Correo al que pertenece la clave a regenerar")
            @RequestParam String correo) throws ControllerException {
        // pase lo que pase esté endpoint siempre regresa algo "bueno", para no alentar el "enumeration atack"
        return usuarioService.solicitaRegeneracionClave(correo);
    }

    @ApiOperation(
            value = "AccessController::ConfirmaRegeneraClave",
            notes = "Para regenerar su clave el usuario envía el token recibido por correo electrónico" +
                    "e introduce su nueva clave de acceso.")
    @GetMapping(
            path = "/confirma-regenera-clave",
            produces = "application/json; charset=utf-8")
    public Usuario confirmaRegeneraClave(
            @ApiParam(name = "token", value = "Token de confirmación del registro enviado por correo")
            @RequestParam String token,
            @ApiParam(name = "clave", value = "Nueva clave a actualizar")
            @RequestParam String clave) throws ControllerException {
        return usuarioService.confirmaRegeneraClave(token, clave);
    }

    @PutMapping(
            path = "/cambia-clave",
            produces = "application/json; charset=utf-8")
    public Usuario cambiaClave(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "credenciales",
                    value = "Correo y clave nueva del usuario al que se piensa cambiar la clave")
            @RequestBody CredencialesRequest credenciales
            ) throws ControllerException {
         String decoded = jwtInstance.decodeJwt(jwt);
         jwtInstance.revisaSender(decoded, credenciales.getUsuario());
         return this.usuarioService.cambiaClave(
                 credenciales.getUsuario(),
                 credenciales.getClave());
    }

    @ApiOperation(
            value = "AccessController::bitso",
            notes = "Se utiliza para recuperar el precio actual de BTC en moneda mexicana.")
    @GetMapping(
            path = "/bitso",
            produces = "application/json; charset=utf-8")
    public String bitso() {
        return invokeRestService.getBitsoInfo();
    }

    @ApiOperation(
            value = "AccessController::binance",
            notes = "Se utiliza para recuperar el precio actual de BTC en dólares.")
    @GetMapping(
            path = "/binance",
            produces = "application/json; charset=utf-8")
    public String binance() {
        return invokeRestService.getBinanceInfo();
    }

    @ApiOperation(value = "AdminController::logout", notes = "Provoca un 'logout' del usuario firmado en el sistema")
    @GetMapping(path = "/logout", produces = "application/json; charset=utf-8")
    public String logout(HttpServletRequest request) throws ServletException {
        String name = "tavo";
        request.logout();
        String res = "{-" + name + "-:-you have been loged out-}";
        return res.replace('-', '"');
    }

    @ApiOperation(
        value = "UsuarioCompletoController::getAll",
        notes = "Regresa una lista de todos los objetos UsuarioCompleto "
            + "debidamente paginados con base en el payload de "
            + "request que determina el tamaño de la página, la "
            + "longitud de la página, el campo por el que se va a "
            + "ordenar y si el orden es ascendente o descendente."
            + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la lista resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(
        value = "/usuario-completos",
        produces = "application/json; charset=utf-8")
    public List<UsuarioCompleto> getAllUsuarioCompleto() throws ControllerException {
        return usuarioCompletoService.getAll();
    }

    @ApiOperation(
        value = "UsuarioCompletoController::get",
        notes = "Regresa un objeto UsuarioCompleto cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/usuario-completo/{id}",
        produces = "application/json; charset=utf-8")
    public UsuarioCompleto getUsuarioCompleto(
        @ApiParam(name="id", value="Representa el id del usuarioCompleto buscado.")
        @PathVariable int id
    ) throws ControllerException {
        return this.usuarioCompletoService.getById(id);
    }

    @ApiOperation(
        value = "UsuarioCompletoController::update",
        notes = "Recibe un objeto UsuarioCompleto, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/usuario-completo",
            produces = "application/json; charset=utf-8")
    public int update(
        @ApiParam(name="usuarioCompleto", value="UsuarioCompleto que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
        @RequestBody UsuarioCompleto usuarioCompleto
    ) throws ControllerException {
        return usuarioCompletoService.update(usuarioCompleto);
    }

    @GetMapping(
            value = "/usuario-completos-paginated",
            produces = "application/json; charset=utf-8")
    public List<UsuarioCompleto> getAllUsuarioCompletoPaginado(int pageNumber, int pageSize) throws ControllerException {
        return usuarioCompletoService.getAllPaginated(pageNumber, pageSize);
    }

    @GetMapping(
            path = "/usuarios/{id}",
            produces = "application/json; charset=utf-8")
    public Usuario getUser(
            @ApiParam(
                    name = "id",
                    value = "ID del Usuario",
                    defaultValue = "1")
            @PathVariable int id
            ) throws ControllerException {
        return this.accessHelperService.getUsuarioById(id);
    }

    @GetMapping(
            path = "/usuarios",
            produces = "application/json; charset=utf-8")
    public List<Usuario> getAllUsers() throws ControllerException {
        return this.accessHelperService.getTodosUsuarios();
    }

    @GetMapping(
            path = "/count-users",
            produces = "application/json; charset=utf-8")
    public int countUsers() throws ControllerException {
        return this.accessHelperService.getTodosUsuarios().size();
    }

    @PostMapping(
            path = "/usuarios-thin",
            produces = "application/json; charset=utf-8")
    public Usuario createUserThin(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "credenciales",
                    value = "Crea un Usuario empleando sólo sus credenciales")
            @RequestBody CredencialesRequest credenciales
            ) throws ControllerException {
        this.verifica(jwt, "ADMIN"); // o sea: CUALQUIER administrador (y no otro rol) puede crear un nuevo usuario
        return this.accessHelperService.createUsuario(credenciales);
    }

    @PostMapping(
            path = "/usuarios",
            produces = "application/json; charset=utf-8")
    public Usuario createUser(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "usuario",
                    value = "Crea un Usuario empleando todos sus atributos")
            @RequestBody Usuario usuario
            ) throws ControllerException {
        this.verifica(jwt, "ADMIN"); // o sea: CUALQUIER administrador (y no otro rol) puede crear un nuevo usuario
        return this.accessHelperService.createUsuario(usuario);
    }

    @PutMapping(
            path = "/usuarios",
            produces = "application/json; charset=utf-8")
    public Usuario updateUsuario(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "usuario",
                    value = "Actualiza un Usuario empleando todos los atributos provistos")
            @RequestBody Usuario usuario
            ) throws ControllerException {
         this.verifica(jwt, "ADMIN"); // o sea: sólo un administrador puede actualizar a un usuario cualquiera
         this.accessHelperService.updateUsuario(usuario);
         return usuario;
    }

    @DeleteMapping(
            path = "/usuarios",
            produces = "application/json; charset=utf-8")
    public Usuario borraUsuario(
            @ApiParam(
                    name = "id",
                    value = "Borra un Usuario cuyo ID es dado")
            @RequestParam int id) throws ControllerException {
         return this.accessHelperService.deleteUsuario(id);
    }

    private void verifica(String token, String targetRol) throws ServiceException {
        String mail = jwtInstance.getCorreoFromDecoded(token);
        List<Rol> rolesForToken = this.accessHelperService.getRolesDelCorreo(mail);
        for(Rol rol : rolesForToken) {
            if(rol.getNombre().equalsIgnoreCase(targetRol)) {
                return;
            }
        }
        throw new CustomException(EnumMessage.NOT_AUTHORIZED);
    }

    /*
    private void verifica(String token, String correo, String targetRol) throws ServiceException {
        String mail = JWTUtil.getInstance().getMail(token, this.encryptKey);
        List<Rol> rolesForToken = this.usuarioService.obtenRolesDeUsuario(mail);
        List<Rol> rolesForUsuario = this.usuarioService.obtenRolesDeUsuario(correo);
        if(rolesForToken==null || rolesForUsuario==null || rolesForUsuario.size()<1 || rolesForToken.size()<1) {
            throw new CustomException(EnumMessage.ISSUER_NOT_VERIFIED);
        }
        for(Rol x : rolesForToken) {
            for(Rol y : rolesForUsuario) {
                if(x.getId()==y.getId()) {
                    if(x.getNombre().equals(targetRol)) {
                        return;
                    }
                }
            }
        }
        throw new CustomException(EnumMessage.ISSUER_NOT_VERIFIED);
    }
*/
    @PutMapping(
            path = "/usuario-detalles",
            produces = "application/json; charset=utf-8")
    public UsuarioDetalle updateUsuarioDetalles(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "usuarioDetalle",
                    value = "Actualiza un UsuarioDetalle empleando todos los atributos provistos")
            @RequestBody UsuarioDetalle usuarioDetalle
            ) throws ControllerException {
         return this.usuarioService.actualizaUsuarioDetalle(usuarioDetalle);
    }

    @ApiOperation(
            value = "AccessController::consulta",
            notes = "Se utiliza para recuperar el precio actual de BTC en dólares.")
    @GetMapping(
            path = "/consulta",
            produces = "application/json; charset=utf-8")
    public List<ConsultaResponse> consulta(@RequestHeader("jwt") String jwt) throws ControllerException {
        return consultaService.consulta(jwt);
    }

    @ApiOperation(
            value = "AccessController::guarda",
            notes = "Se utiliza para recuperar el precio actual de BTC en dólares.")
    @PostMapping(
            path = "/guarda",
            produces = "application/json; charset=utf-8")
    public String guarda(
            @RequestHeader("jwt") String jwt,
            @RequestBody List<ConsultaRequest> datos) throws ControllerException {
        return consultaService.guarda(jwt, datos);
    }
    @ApiOperation(
            value = "AccessController::descripcion",
            notes = "Se utiliza para guardar la descripción de un usuario")
    @PostMapping(
            path = "/descripcion",
            produces = "application/json; charset=utf-8")
    public Usuario guardaDescripcion(
            @RequestHeader("jwt") String jwt,
            @RequestBody DescripcionRequest descripcionRequest) throws ControllerException {
        String decoded = jwtInstance.decodeJwt(jwt);
        jwtInstance.revisaSender(decoded, descripcionRequest.getCorreo());
        return this.usuarioService.updateProfileDesc(descripcionRequest.getCorreo(), descripcionRequest.getDescripcion(), descripcionRequest.getDescripcionPlaneText());
    }
    
}
