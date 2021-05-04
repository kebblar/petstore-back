package io.kebblar.petstore.api.model.domain;
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Criterio.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (23_21)
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *
 */
public class Criterio {
	
	/**
	 * Implementacion del POJO de la entidad de 'Criterio'.
	 * 
	 * @author  garellano
	 * @version 1.0-SNAPSHOT
	 * @since   1.0-SNAPSHOT
	 */
	
    private int idCategoria;
    private int valor;

    public Criterio() {
    }
    public Criterio(int idCategoria, int valor) {
        this.idCategoria = idCategoria;
        this.valor = valor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCategoria;
        result = prime * result + valor;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Criterio other = (Criterio) obj;
        if (idCategoria != other.idCategoria)
            return false;
        if (valor != other.valor)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Criterio [idCategoria=" + idCategoria + ", valor=" + valor + "]";
    }

}
