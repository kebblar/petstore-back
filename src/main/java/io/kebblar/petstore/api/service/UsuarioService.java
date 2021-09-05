/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
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

import java.util.List;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
/**
 * <p>Definición de la interfaz de servicios para 'Usuario'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface UsuarioService {
    /**
     * <p>Crea un objeto de tipo {@link Usuario} a partir su correo y una clave.
     *
     * @param Objeto de tipo {@link CredencialesRequest} con la información de su correo y su clave.
     * @return Objeto de tipo {@link Usuario} que es creado.
     * @throws BusinessException
     */
    Usuario creaUsuario(CredencialesRequest cred) throws BusinessException;

    /**
     * <p>Crea un objeto de tipo {@link Usuario} a partir del nuevo
     * usuario dado usando como pivote su id.
     *
     * @param Objeto de tipo {@link Usuario} con la información a insertar.
     * @return Objeto de tipo {@link Usuario} que es el usuario dado.
     * @throws BusinessException
     */
    Usuario creaUsuario(Usuario usuario) throws BusinessException;

    /**
     * <p>Actualiza un objeto de tipo {@link Usuario} a partir del nuevo
     * usuario dado usando como pivote su id.
     *
     * @param Objeto de tipo {@link Usuario} con la información a actualizar.
     * @return Objeto de tipo {@link Usuario} que es el usuario dado.
     * @throws BusinessException
     */
    Usuario actualizaUsuario(Usuario usuario) throws BusinessException;

    /**
     * <p>Retorna un objeto de tipo {@link Usuario} a partir del ID dado.
     *
     * @param id Entero asociado a un usuario específico.
     * @return Objeto de tipo {@link Usuario}.
     * @throws BusinessException
     */
    Usuario obtenUsuarioPorId(int id) throws BusinessException;

    /**
     * <p>Elimina de manera lógina (y no física) a un objeto de
     * tipo {@link Usuario} a partir del ID dado. Adicionalmente,
     * retorna el objeo eleiminado.
     *
     * @param Entero con el ID de un usuario específico.
     * @return Objeto de tipo {@link Usuario} dado originalmente.
     * @throws BusinessException
     */
    Usuario eliminaUsuario(int id) throws BusinessException;

    /**
     * <p>Retorna un objeto de tipo {@link Usuario} a partir del correo dado.
     *
     * @param correo Cadena que contiene el correo de un usuario específico.
     * @return Objeto de tipo {@link Usuario}.
     * @throws BusinessException
     */
    Usuario obtenUsuarioPorCorreo(String correo) throws BusinessException;

    /**
     * <p>Retorna la lista todos los objetos de tipo {@link Usuario} registrados
     * en el sistema.
     * <p>Si ocurre algún error en su recuperación, se dispara la excepción
     * de tipo: {@link BusinessException}.
     * @return Lista de objetos de tipo {@link Usuario}.
     * @throws BusinessException
     */
    List<Usuario> obtenTodosUsuarios() throws BusinessException;

    /**
     * <p>Retorna una lista de objetos de tipo {@link Rol} que están
     * asociadas a un usuario específico identificado por su ID.
     * <p>Si el usuario no tiene Roles asociadas, regresa una lista vacía.
     * <p>Si ocurre algún error en su recuperación, se dispara la excepción
     * de tipo: {@link BusinessException}.
     * @param id Entero asociado a un usuario específico
     * @return Lista de objetos de tipo {@link Rol}.
     * @throws BusinessException
     */
    List<Rol> obtenRolesDeUsuario(int id) throws BusinessException;

    /**
     * <p>Retorna una lista de objetos de tipo {@link Direccion} que están
     * asociadas a un usuario específico identificado por su ID.
     * <p>Si el usuario no tiene direcciones asociadas, regresa una lista vacía.
     * <p>Si ocurre algún error en su recuperación, se dispara la excepción
     * de tipo: {@link BusinessException}.
     * @param id Entero asociado a un usuario específico
     * @return Lista de objetos de tipo {@link Direccion}.
     * @throws BusinessException
     */
    //List<Direccion> obtenDireccionesDeUsuario(int id) throws BusinessException;

    /**
     * <p>Retorna los detalles de un usuario cuyo ID es dado como parámetro formal.
     * <p>En caso de que no sea posile obtener sus detalles, se dispara una
     * excepción de tipo {@link BusinessException}.
     *
     * @param id Entero asociado a un usuario específico
     * @return Objeto {@link UsuarioDetalle}
     * @throws BusinessException
     */
    UsuarioDetalle obtenDetallesDeUsuario(int id) throws BusinessException;

    /**
     * Realiza el preregistro de un potencial usuario al sistema
     *
     * @param preRegistroRequest
     * @return Preregistro mismo objeto recibido
     * @throws BusinessException
     */
    Preregistro preRegistro(Preregistro preRegistroRequest) throws BusinessException;

    /**
     * Similar a preRegistro. La diferencia es que PreregistroRequest no tiene Date y a cambio,
     * tiene tres campos numéricos: year, month y day
     *
     * @param preRegistroRequest
     * @return Retorna la estructura de datos que recive transformada en un objeto de tipo Preregistro
     *
     * @throws BusinessException
     */
    Preregistro preRegistro2(PreregistroRequest preRegistroRequest) throws BusinessException;

    /**
     * Confirma el registro de un usuario al sistema
     *
     * @param token Cadena con la clave de confirmación del registro
     * @return entero con el id del usuario recién confirmado (debe ser mayor a cero)
     * @throws BusinessException
     */
    Usuario confirmaPreregistro(String token) throws BusinessException;

    /**
     * Solicita la regeneración de una clave perdida u olvidada
     *
     * @param correo String asociado a la clave olvidada
     * @return
     * @throws BusinessException
     */
    Usuario solicitaRegeneracionClave(String correo);

    /**
     * Confirma la regeneracion de una nueva clave a un usuario
     *
     * @param token String asociado a un usuario
     * @param clave Nueva clave
     *
     * @return Usuario asignado
     * @throws BusinessException
     */
    Usuario confirmaRegeneraClave(String token, String clave) throws BusinessException;

    /**
     * Cambia la clave de un usuario por la que de proporciona
     *
     * @param correo Correo asociado al usuario
     * @param clave Nueva clave entexto plano
     * @return el objeto de tipo Usuario con la clave cambiada
     * @throws BusinessException
     */
    Usuario cambiaClave(String correo, String clave) throws BusinessException;

    /**
     * Actualiza la información adicional de un usuario en su tabla "usuario_detalle".
     *
     * @param usuarioDetalle Información a ser actualizada
     * @return Información actualizada
     * @throws BusinessException
     */
    UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException;
}
