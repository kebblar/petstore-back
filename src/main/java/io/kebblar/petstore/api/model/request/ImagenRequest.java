/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ImagenRequest.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez (JC)
 * Fecha:       Sabado 8 de Mayo de 2021 (09_38)
 *
 * Historia:    20210508_0938 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.request;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

/**
 * Implementacion del POJO de la entidad de 'ImagenRequest'.
 * 
 * @author  Javier Chàvez
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ImagenRequest {

	private int id;//Identificador del anuncio
	private MultipartFile[] files;
	
	public ImagenRequest() {
	}
	
	public ImagenRequest(int id, MultipartFile[] files) {
		this.id = id;
		this.files = files;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "ImagenRequest [id=" + id + ", files=" + Arrays.toString(files) + "]";
	}
}
