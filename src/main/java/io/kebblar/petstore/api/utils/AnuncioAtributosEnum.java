/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioEstatusEnum.java
 * Tipo:        Enum
 * AUTOR:       Maria Isabel Contreras Garcia
 * Fecha:       Jueves 20 de Mayo de 2021 (23_03)
 *
 * Historia:    .
 *              20210520_2303 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.utils;

/**
 * <p>Descripción:</p>
 * ENUM asociado a los atributos de la entidad 'anuncio'. 
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public enum AnuncioAtributosEnum {

	PESO (1, "PESO"),
	RAZA (2, "RAZA"),
	COLOR (3, "COLOR"),
	TAMANIO (4, "TAMAÑO"),
	EDAD (5, "EDAD"),
	LONGEVIDAD (6, "LONGEVIDAD"),
	TIPO_AGUA (7, "TIPO DE AGUA");
	
	private int idAtributo;
	private String descAtributo;
	
	AnuncioAtributosEnum(int idAtributo, String descAtributo) {
		this.idAtributo = idAtributo;
		this.descAtributo = descAtributo;
	}

	public int getIdAtributo() {
		return idAtributo;
	}

	public String getDescAtributo() {
		return descAtributo;
	}

	public static String getDescripcion(int idEnum){
		for(AnuncioAtributosEnum eu:AnuncioAtributosEnum.values()){
			if(eu.getIdAtributo() == idEnum){
				return eu.getDescAtributo();
			}
		}
		return "";
	}

}
