
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion 
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 * 
 * Artefacto:   UsuarioHabilidad .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Wednesday 12 de December de 2021 (16_27)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20211215_1627 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'usuario_habilidad'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class UsuarioHabilidad implements Serializable {

    private static final long serialVersionUID = -3321107016604617160L;

    /**
     * Atributos de la clase
     */
    private int idUsuario;
    private int idHabilidad;
    private int costo;

    /**
     * Constructor por default (sin parámetros).
     */
    public UsuarioHabilidad() {
    }


    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public UsuarioHabilidad(int idUsuario, int idHabilidad, int costo) {
        this.idUsuario = idUsuario;
        this.idHabilidad = idHabilidad;
        this.costo = costo;
    }

    /**
     * Getter para idUsuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Setter para idUsuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * Getter para idHabilidad.
     */
    public int getIdHabilidad() {
        return idHabilidad;
    }
    
    /**
     * Setter para idHabilidad.
     */
    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
    
    /**
     * Getter para costo.
     */
    public int getCosto() {
        return costo;
    }
    
    /**
     * Setter para costo.
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }
    

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[UsuarioHabilidad] : ["
                + " idUsuario =" + this.idUsuario
                + " idHabilidad =" + this.idHabilidad
                + " costo =" + this.costo
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase UsuarioHabilidad son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsuarioHabilidad)) {
            return false;
        }
        UsuarioHabilidad other = (UsuarioHabilidad) obj;
        return
               idUsuario == other.idUsuario && 
               idHabilidad == other.idHabilidad && 
               costo == other.costo; 
    }
    
    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            idUsuario, 
            idHabilidad, 
            costo
        );
    }

}
