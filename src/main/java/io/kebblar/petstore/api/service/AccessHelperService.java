package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.exceptions.CustomException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;

public interface AccessHelperService {

    /**
     * Obtiene la foto de perfil de un usuario.
     * @param idUser id del usuario
     * @return cadena que corresponde al nombre de su foto
     */
    String getProfilePic(int idUser) throws ServiceException;

    /**
     * Método auxiliar que valida si se ingreso alguna credencial vacía.
     * @param usr corresponde al usuariuo de inicio de sesión.
     * @param clave corresponde a la clave de inicio de sesión.
     * @throws CustomException
     */
    void validateCredentialsFormat(String usr, String clave) throws CustomException;

    /**
     * Método privado para actualizar la información de un usuario en el sistema.
     * @param usuario objeto usuario a actualizar.
     * @throws CustomException En caso que ocurra algún problema con la actualización.
     */
    void updateUsuario(Usuario usuario) throws ServiceException;

    Usuario getUsuarioByCorreo(String correo) throws ServiceException;

    List<Rol> getUserRoles(int userId) throws ServiceException;

    UsuarioDetalle getUsuarioDetalle(int userId) throws ServiceException;

    //UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws ServiceException;

    String getCorreoFromJwt(String jwt);

    Usuario getByToken(String token);

    void confirmaRegeneraClave(String token, String claveHash);

    Preregistro getRegistroByMail(String correo) throws ServiceException;

    int insertRegistro(Preregistro preRegistroRequest) throws ServiceException;

    int updateRegistro(Preregistro preRegistroRequest) throws ServiceException;

    int insertUsuario(Usuario usuario) throws ServiceException;

    int insertUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws ServiceException;

    int insertUserRol(int idUsuario, int rolId) throws ServiceException;

    int deletePreregistroByRandomString(String randomString) throws ServiceException;

    /**
     * <p>Crea un objeto de tipo {@link Usuario} a partir su correo y una clave.
     *
     * @param cred de tipo {@link CredencialesRequest} con la información de su correo y su clave.
     * @return Objeto de tipo {@link Usuario} que es creado.
     * @throws ServiceException if any
     */
    Usuario createUsuario(CredencialesRequest cred) throws ServiceException;

    /**
     * <p>Crea un objeto de tipo {@link Usuario} a partir del nuevo
     * usuario dado usando como pivote su id.
     *
     * @param usuario de tipo {@link Usuario} con la información a insertar.
     * @return Objeto de tipo {@link Usuario} que es el usuario dado.
     * @throws ServiceException if any
     */
    Usuario createUsuario(Usuario usuario) throws ServiceException;

    /**
     * <p>Retorna un objeto de tipo {@link Usuario} a partir del ID dado.
     *
     * @param id Entero asociado a un usuario específico.
     * @return Objeto de tipo {@link Usuario}.
     * @throws ServiceException if any
     */
    Usuario getUsuarioById(int id) throws ServiceException;

    /**
     * <p>Retorna la lista todos los objetos de tipo {@link Usuario} registrados
     * en el sistema.
     * <p>Si ocurre algún error en su recuperación, se dispara la excepción
     * de tipo: {@link ServiceException}.
     * @return Lista de objetos de tipo {@link Usuario}.
     * @throws ServiceException if any
     */
    List<Usuario> getTodosUsuarios() throws ServiceException;

    /**
     * <p>Elimina de manera lógina (y no física) a un objeto de
     * tipo {@link Usuario} a partir del ID dado. Adicionalmente,
     * retorna el objeo eleiminado.
     *
     * @param id con el ID de un usuario específico.
     * @return Objeto de tipo {@link Usuario} dado originalmente.
     * @throws ServiceException if any
     */
    Usuario deleteUsuario(int id) throws ServiceException;

    /**
     * <p>Retorna una lista de objetos de tipo {@link Rol} que están
     * asociadas a un usuario específico identificado por su ID.
     * <p>Si el usuario no tiene Roles asociadas, regresa una lista vacía.
     * <p>Si ocurre algún error en su recuperación, se dispara la excepción
     * de tipo: {@link ServiceException}.
     * @param id Entero asociado a un usuario específico
     * @return Lista de objetos de tipo {@link Rol}.
     * @throws CustomException if any
     */
    List<Rol> getRolesDelUsuario(int id) throws CustomException;

    /**
     * <p>Retorna una lista de objetos de tipo {@link Rol} que están
     * asociadas a un usuario específico identificado por su correo.
     *
     * @param correo Cadena asociada al mail de un usuario específico
     * @return Lista de objetos de tipo {@link Rol}.
     * @throws CustomException if any
     */
    List<Rol> getRolesDelCorreo(String correo) throws CustomException;

    /**
     * Obtiene la tupla de la tabla preregistro que tiene asociado el token proporcionado
     * por correo al momento del registro.
     *
     * @param token proporcionado por correo al momento del registro.
     * @return Objeto de tipo Preregistro ta que su RamdomString coincide con el token dado
     * @throws CustomException if any
     */
    Preregistro getPreregistroByRandomString(String token) throws CustomException;

    /**
     * <p>Retorna los detalles de un usuario cuyo ID es dado como parámetro formal.
     * <p>En caso de que no sea posible obtener sus detalles, se dispara una
     * excepción de tipo {@link ServiceException}.
     *
     * @param id Entero asociado a un usuario específico
     * @return Objeto {@link UsuarioDetalle}
     * @throws CustomException if any
     @Override
    */
    UsuarioDetalle getDetallesDeUsuario(int id) throws CustomException;

    int uploadFotoPerfil(int idUser, String nuevoNombre) throws CustomException;

    int updateUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws ServiceException;
    
    String getProfileDesc(int idUser) throws ServiceException;

    int updateProfileDesc(int idUser, String descripcion, String descripcionPlaneText) throws ServiceException;

}
    
