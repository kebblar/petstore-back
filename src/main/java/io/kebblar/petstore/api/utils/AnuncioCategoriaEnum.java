/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioCategoriaEnum.java
 * Tipo:        Enum
 * AUTOR:       Maria Isabel Contreras Garcia
 * Fecha:       Lunes 24 de Mayo de 2021 (17_55)
 *
 * Historia:    .
 *              20210524_1755 Creación de éste ENUM
 *
 */
package io.kebblar.petstore.api.utils;

/**
 * <p>Descripción:</p>
 * ENUM asociado a las categorias de la entidad 'anuncio'. 
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public enum AnuncioCategoriaEnum {

	CANINOS (1, "Caninos"),
	FELINOS (2, "Felinos"),
	ARACNIDOS (3, "Aracnidos"),
	REPTILES (4, "Reptiles"),
	PECES (5, "Peces"),
	AVES (6, "Aves"),
	ROEDORES (7, "Roedores");
	
	private int id;
	private String descripcion;
	
	AnuncioCategoriaEnum(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public static String getDescripcion(int idEnum){
		for(AnuncioCategoriaEnum eu:AnuncioCategoriaEnum.values()){
			if(eu.getId() == idEnum){
				return eu.getDescripcion();
			}
		}
		return "";
	}
}
