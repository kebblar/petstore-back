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
 * ENUM de valores asociado a los atributos de la entidad 'anuncio'. 
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public enum AnuncioValAtributosEnum {

	PESO_1 (1,1, "MENOS DE 1 KG"),
	PESO_2 (1,2, "ENTRE 1 Y 2 KG"),
	PESO_3 (1,3, "ENTRE 2 Y 5 KG"),
	PESO_4 (1,4, "ENTRE 5 Y 10 KG"),
	PESO_5 (1,5, "ENTRE 10 Y 20 KG"),
	PESO_6 (1,6, "MAS DE 20 KG"),	
	RAZA_1 (2,1, "TERRANOVA"),
	RAZA_2 (2,2, "MALTES"),
	RAZA_3 (2,3, "GOLDEN RETRIEVERS"),
	RAZA_4 (2,4, "HUSKIE SIBERIANO"),
	RAZA_5 (2,5, "POODLES"),
	RAZA_6 (2,6, "BEAGLES"),
	RAZA_7 (2,7, "PASTOR ALEMÁN"),
	RAZA_8 (2,8, "CORGIS"),
	RAZA_9 (2,9, "LABRADOR"),
	RAZA_10 (2,10, "CHIHUAHUA"),
	RAZA_11 (2,11, "MESTIZO"),
	RAZA_12 (2,12, "PUG"),
	RAZA_13 (2,13, "BULLDOG"),
	COLOR_1 (3,1, "BLANCO"),
	COLOR_2 (3,2, "NEGRO"),
	COLOR_3 (3,3, "CAFE"),
	COLOR_4 (3,4, "AZUL"),
	COLOR_5 (3,5, "AMARILLO"),
	COLOR_6 (3,6, "VERDE"),
	COLOR_7 (3,7, "DORADO"),
	COLOR_8 (3,8, "PLATEADO"),
	COLOR_9 (3,9, "GRIS"),
	COLOR_10 (3,10, "ROSA"),
	COLOR_11 (3,11, "MIXTO"),
	TAMANIO_1 (4,1, "CHICO"),
	TAMANIO_2 (4,2, "MEDIANO"),
	TAMANIO_3 (4,3, "GRANDE"),
	TAMANIO_4 (4,4, "ENORME"),
	EDAD_1 (5,1, "MENOS DE 1 MES"),
	EDAD_2 (5,2, "DE 1 A 6 MESES"),
	EDAD_3 (5,3, "DE 6 A 12 MESES"),
	EDAD_4 (5,4, "DE 1 A 2 AÑOS"),
	EDAD_5 (5,5, "DE 2 A 3 AÑOS"),
	EDAD_6 (5,6, "DE 3 A 4 AÑOS"),
	EDAD_7 (5,7, "DE 5 A 6 AÑOS"),
	EDAD_8 (5,8, "DE 6 A 7 AÑOS"),
	EDAD_9 (5,9, "DE 7 A 8 AÑOS"),
	EDAD_10 (5,10, "DE 8 A 9 AÑOS"),
	EDAD_11 (5,11, "DE 9 A 10 AÑOS"),
	EDAD_12 (5,12, "MAS DE 10 AÑOS"),
	LONGEVIDAD_1 (6,1, "MENOS DE 1 AÑO"),
	LONGEVIDAD_2 (6,2, "DE 1 A 2 AÑOS"),
	LONGEVIDAD_3 (6,3, "DE 2 A 5 AÑOS"),
	LONGEVIDAD_4 (6,4, "DE 5 A 10 AÑOS"),
	LONGEVIDAD_5 (6,5, "DE 10 A 15 AÑOS"),
	LONGEVIDAD_6 (6,6, "DE 15 A 20 AÑOS"),
	LONGEVIDAD_7 (6,7, "DE 20 A 30 AÑOS"),
	LONGEVIDAD_8 (6,8, "MAS DE 30 AÑOS"),
	TIPO_AGUA_1 (7,1, "AGUA DULCE"),
	TIPO_AGUA_2 (7, 2,"AGUA SALADA"),
	TIPO_AGUA_3 (7, 3,"DULCE Y SALADA");
	
	private int idAtributo;
	private int idValor;
	private String descValor;
	
	private AnuncioValAtributosEnum(int idAtributo, int idValor, String descValor) {
		this.idAtributo = idAtributo;
		this.idValor = idValor;
		this.descValor = descValor;
	}

	public int getIdAtributo() {
		return idAtributo;
	}

	public int getIdValor() {
		return idValor;
	}

	public String getDescValor() {
		return descValor;
	}

	public static String getDescValor(int idAtributo,int idValor){
		for(AnuncioValAtributosEnum eu:AnuncioValAtributosEnum.values()){
			if(eu.getIdAtributo()== idAtributo && eu.getIdValor()== idValor){
				return eu.getDescValor();
			}
		}
		return "";
	}

}
