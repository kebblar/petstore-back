package io.kebblar.petstore.api.model.request;

import java.util.Objects;

public class NuevaDireccion {

    /**
     * Atributos de la clase.
     */
    private int id;
    private int idUsuario;
    private String nombre;
    private int tipo;
    private String calleNumero;
    private String colonia;
    private String referencias;
    private String cp;
    private int idPais;
    private int idEstado;
    private int idMunicipio;

    /**
     * Constructor sin parametros.
     */
    public NuevaDireccion() {}

    public NuevaDireccion(int id, int idUsuario, String nombre, int tipo, String calleNumero, String colonia, String referencias, String cp, int idPais, int idEstado, int idMunicipio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.referencias = referencias;
        this.cp = cp;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
    }

    /**
     * Getter para id.
     * @return id del objeto
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para id.
     * @param id id que será insertado
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Getter para el id del usuario.
     * @return id del usuario asociado
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    /**
     * Setter para idUsuario.
     * @param idUsuario id del usuario que será insertado
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    /**
     * Getter para nombre del destinatario.
     * @return nombre del destinatario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para nombre.
     * @param nombre nombre insertado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter para tipo.
     * @return id del tipo de direccion
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Setter para tipo.
     * @param tipo representa el id del tipo de direccion
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    /**
     * Getter para calle y numero.
     * @return cadena que representa a la calle y numero
     */
    public String getCalleNumero() {
        return calleNumero;
    }

    /**
     * Setter para calle y número.
     * @param calleNumero representan la calle y el número
     */
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }
    /**
     * Getter para colonia.
     * @return cadena que representa la colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Setter para colonia.
     * @param colonia Representa la colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    /**
     * Getter para referencias.
     * @return cadena que representa las referencias
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * Setter para referencias.
     * @param referencias Representa las referencias de entrega
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
    /**
     * Getter para código postal.
     * @return cadena que representa el código postal
     */
    public String getCp() {
        return cp;
    }

    /**
     * Setter para cp.
     * @param cp Es el código postal
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Regresa el id del país de la dirección.
     * @return id del pais.
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * Setter para pais.
     * @param idPais inserta el id de un país.
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdEstado() {
        return idEstado;
    }
    /**
     * Setter para estado.
     * @param idEstado inserta el id de un estado.
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }
    /**
     * Setter para municipio.
     * @param idMunicipio inserta el id de un municipio.
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * Compara dos objetos de tipo nueva dirección.
     * @param o objeto con el que será comparado.
     * @return true si son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuevaDireccion)) return false;
        NuevaDireccion that = (NuevaDireccion) o;
        return id == that.id && idUsuario == that.idUsuario && tipo == that.tipo && idPais == that.idPais && idEstado == that.idEstado && idMunicipio == that.idMunicipio && Objects.equals(nombre, that.nombre) && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(referencias, that.referencias) && Objects.equals(cp, that.cp);
    }

    /**
     * Método hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, nombre, tipo, calleNumero, colonia, referencias, cp, idPais, idEstado, idMunicipio);
    }

    /**
     * Genera la representación de cadena del objeto
     */
    @Override
    public String toString() {
        return "NuevaDireccion{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", calleNumero='" + calleNumero + '\'' +
                ", colonia='" + colonia + '\'' +
                ", referencias='" + referencias + '\'' +
                ", cp='" + cp + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", idMunicipio=" + idMunicipio +
                '}';
    }
}
