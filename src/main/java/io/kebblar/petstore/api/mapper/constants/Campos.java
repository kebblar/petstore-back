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
 * Artefacto:   Campos.java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       miércoles 09 de septiembre 2021 (19_06)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_1906 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper.constants;

/**
 * <p>Descripción:</p>
 * Clase para almacenar las constantes que se utilizan en los mapper de este paquete.
 *
 * @author  Fhernanda
 * @see     io.kebblar.petstore.api.mapper
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public final class Campos {

    public static final String CAMPOS_ANUNCIO = " id_categoria, folio, titulo, descripcion, precio, fecha_inicio_vigencia, " +
            "fecha_fin_vigencia, fecha_alta, fecha_modificacion, fecha_eliminacion, id_estatus, search_url ";
    public static final String CAMPOS_MASCOTA_VALOR_ATRIBUTOS = " id_anuncio, id_valor_atributo ";
    public static final String CAMPOS_ANUNCIO_MEDIA = " id_anuncio, uuid, id_tipo, principal ";
    public static final String CAMPOS_ATRIBUTO = " id, nombre, activo ";
    public static final String CAMPOS_CARRITO = " id, id_usuario, id_anuncio, cve_orden_compra ";
    public static final String CAMPOS_CAT_ATRIBUTO = " id_categoria, id_atributo ";
    public static final String CAMPOS_CATEGORIA = " id, categoria, activo ";
    public static final String CAMPOS_CRIPTO = "id, id_usuario, id_direccion, wallet, id_paqueteria, status, monto, fecha, " +
            "descripcion, last_balance";
    public static final String CAMPOS_DIRECCION = " id, calle_numero, colonia, id_pais, id_estado, id_municipio, " +
            "id_tipo_direccion, cp, referencias, activo ";
    public static final String CAMPOS_EDO = " id, id_pais, nombre ";
    public static final String CAMPOS_ESTATUS_ANUNCIO = " id, descripcion ";
    public static final String CAMPOS_GRAFICA1 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, " +
            "cat.categoria as categoria, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    public static final String IJ_CARRITO_ORDEN = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  " +
            "carrito.cve_orden_compra";
    public static final String IJ_ANUNCIO_CARRITO = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";
    public static final String IJ_CATEGORIA_ANUNCIO = " inner join petstore.categoria as cat on cat.id = anuncio.id_categoria";
    public static final String GROUP_CATEGORIA_M_A = " group by anio, mes, categoria";
    public static final String CAMPOS_GRAFICA2 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, " +
            "MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    public static final String GROUP_MES_ANIO = " group by anio, mes";
    public static final String CAMPOS_MEDIA_TIPO = " id, descripcion, activo ";
    public static final String CAMPOS_PAGO = " id, id_usuario, tipopago, num_tarjeta_cartera, expiracion, activo ";
    public static final String CAMPOS_MUN = " id, id_estado, nombre ";
    public static final String CAMPOS_AUX_MUN = " m.id, m.id_estado, m.nombre, e.nombre as nombre_estado , p.nombre as nombre_pais";
    public static final String CAMPOS_ORDEN = " id, id_usuario, id_direccion_envio, id_paqueteria, id_metodo_pago, " +
            "id_moneda, id_anuncio, cve_orden_compra, importe_total, fecha_hora_comprar, estado_envio, recibo ";
    public static final String CAMPOS_PAIS = " id, nombre ";
    public static final String CAMPOS_PAQ = " id, nombre, breve_descripcion, html_descripcion, precio ";
    public static final String CAMPOS_REG = " id, nick, correo, clave_hash, telefono, fecha_nacimiento, random_string, " +
            "instante_registro ";
    public static final String CAMPOS_ROL = " id, nombre, activo ";
    public static final String CAMPOS_T_DIRECC = " id, nombre, activo ";
    public static final String CAMPOS_USER_C = " id, correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular ";
    public static final String CAMPOS_USER_D = " id_usuario, nombre, apellido_paterno, apellido_materno, nick_name, " +
            "fecha_nacimiento, telefono_celular ";
    public static final String CAMPOS_USER = " id, correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, " +
            "instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante ";

    public static final String CAMPOS_V_A = " id, id_atributo, rango, activo ";




}
