/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioImagenRequest.java
 * Tipo:        clase
 * AUTOR:       Isabel Contreras (IC)
 * Fecha:       Miercoles 9 de Junio de 2021 (20_05)
 *
 * Historia:    20210609_2005 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.request;

public class AnuncioImagenRequest {
    private int idAnuncio;
    private String uuid;
    
    public AnuncioImagenRequest() {
    }
    
    public AnuncioImagenRequest(int idAnuncio, String uuid) {
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }
    
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnuncio;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
        AnuncioImagenRequest other = (AnuncioImagenRequest) obj;
        if (idAnuncio != other.idAnuncio)
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "AnuncioImagenRequest [idAnuncio=" + idAnuncio + ", uuid=" + uuid + "]";
    }
    
}
