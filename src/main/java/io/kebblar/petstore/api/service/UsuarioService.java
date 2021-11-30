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
 * Tipo:        Interface
 * Nombre:      UsuarioService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:23:46
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Definición de la interfaz de servicios para 'Usuario'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface UsuarioService {

//    /**
//     * <p>Retorna una lista de objetos de tipo {@link Direccion} que están
//     * asociadas a un usuario específico identificado por su ID.
//     * <p>Si el usuario no tiene direcciones asociadas, regresa una lista vacía.
//     * <p>Si ocurre algún error en su recuperación, se dispara la excepción
//     * de tipo: {@link BusinessException}.
//     * @param id Entero asociado a un usuario específico
//     * @return Lista de objetos de tipo {@link Direccion}.
//     * @throws BusinessException if any
//     */
//    List<Direccion> obtenDireccionesDeUsuario(int id) throws BusinessException;

    /**
     * Realiza el preregistro de un potencial usuario al sistema
     *
     * @param preRegistroRequest conjunto de datos a registrar como un usuario.
     * @return Preregistro mismo objeto recibido
     * @throws BusinessException if any
     */
    Preregistro preRegistro(Preregistro preRegistroRequest) throws BusinessException;

    /**
     * Similar a preRegistro. La diferencia es que PreregistroRequest no tiene Date y a cambio,
     * tiene tres campos numéricos: year, month y day
     *
     * @param preRegistroRequest conjunto de datos a registrar como un usuario.
     * @return Retorna la estructura de datos que recive transformada en un objeto de tipo Preregistro
     *
     * @throws BusinessException if any
     */
    Preregistro preRegistro(PreregistroRequest preRegistroRequest) throws BusinessException;

    /**
     * Confirma el registro de un usuario al sistema
     *
     * @param token Cadena con la clave de confirmación del registro
     * @param delta duración del token
     * @return entero con el id del usuario recién confirmado (debe ser mayor a cero)
     * @throws BusinessException if any
     */
    Usuario confirmaPreregistro(String token, long delta) throws BusinessException;
    Usuario confirmaPreregistro(String token) throws BusinessException;

    /**
     * Solicita la regeneración de una clave perdida u olvidada
     *
     * @param correo String asociado a la clave olvidada
     * @return objeto de la clase {@link Usuario}
     * @throws BusinessException if any
     */
    Usuario solicitaRegeneracionClave(String correo) throws BusinessException;

    /**
     * Confirma la regeneración de una nueva clave a un usuario
     *
     * @param token String asociado a un usuario
     * @param clave Nueva clave
     *
     * @return Usuario asignado
     * @throws BusinessException if any
     */
    Usuario confirmaRegeneraClave(String token, String clave) throws BusinessException;

    /**
     * Cambia la clave de un usuario por la que de proporciona
     *
     * @param correo Correo asociado al usuario
     * @param clave Nueva clave en texto plano
     * @return el objeto de tipo Usuario con la clave cambiada
     * @throws BusinessException if any
     */
    Usuario cambiaClave(String correo, String clave) throws BusinessException;

    /**
     * Actualiza la información adicional de un usuario en su tabla "usuario_detalle".
     *
     * @param usuarioDetalle Información a ser actualizada
     * @return Información actualizada
     * @throws BusinessException if any
     */
    UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException;

    /**
     * Permite subir una foto de perfil.
     * @param files MultipartFile archivo enviados desde el front.
     * @param destinationFolder String path to file destination.
     * @param max long max size allowed for the file.
     * @return Objeto de tipo UploadModel.
     */
    UploadModel storeProfilePicture(MultipartFile files, String destinationFolder, long max, int idUser) throws BusinessException;

    /**
     * Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto LoginResponse cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     *     - No admite usuario ni clave vacios
     *     - Si el usuario no existe, sólo pide que intente de nuevo
     *     - Si el usuaro existe y la clave es errónea, le indicará que le quedan menos intentos
     *     - Si el usuario está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo
     * @param usuario cadena que contiene el usuario
     * @param clave  cadena que contiene la contraseña
     * @return Objeto {@link LoginResponse}
     * @throws BusinessException
     */
    LoginResponse login(String usuario, String clave) throws BusinessException;

    /**
     * Valida si las credencials proporcionadas son correctas o no.
     * En caso de éxito, retorna un objeto LoginResponse cargado con
     * la información requerida por su cliente.
     * Si las credenciales son inválidas, dispara una excepción acorde
     * a el grado de violación de ingreso.
     * Se requiere que el método siga las siguientes reglas:
     *     - No admite usuario ni clave vacios
     *     - Si el usuario no existe, sólo pide que intente de nuevo
     *     - Si el usuaro existe y la clave es errónea, le indicará que le quedan menos intentos
     *     - Si el usuario está bloqueado (con o sin clave correcta) le indicará que debe esperar cierto tiempo
     * @param usuario información del usuario
     * @param claveProporcionada cadena que contiene la contraseña enviada
     * @param delta tiempo de bloqueo
     * @param maximoNumeroIntentosConcedidos numero maximo de intentos permitidos
     * @param instanteActual fecha actual
     * @return Objeto {@link LoginResponse}
     * @throws BusinessException
     */
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException;

}
