package io.kebblar.petstore.api.mapper.constants;

public final class Campos {

    public static final String CAMPOS_ANUNCIO = " id_categoria, folio, titulo, descripcion, precio, fecha_inicio_vigencia, fecha_fin_vigencia, fecha_alta, fecha_modificacion, fecha_eliminacion, id_estatus, search_url ";
    public static final String CAMPOS_MASCOTA_VALOR_ATRIBUTOS = " id_anuncio, id_valor_atributo ";
    public static final String CAMPOS_ANUNCIO_MEDIA = " id_anuncio, uuid, id_tipo, principal ";
    public static final String CAMPOS_ATRIBUTO = " id, nombre, activo ";
    public static final String CAMPOS_CARRITO = " id, id_usuario, id_anuncio, cve_orden_compra ";
    public static final String CAMPOS_CAT_ATRIBUTO = " id_categoria, id_atributo ";
    public static final String CAMPOS_CATEGORIA = " id, categoria, activo ";
    public static final String CAMPOS_CRIPTO = "id, id_usuario, id_direccion, wallet, id_paqueteria, status, monto, fecha, descripcion, last_balance";
    public static final String CAMPOS_DIRECCION = " id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo ";
    public static final String CAMPOS_EDO = " id, id_pais, nombre ";
    public static final String CAMPOS_ESTATUS_ANUNCIO = " id, descripcion ";
    public static final String CAMPOS_GRAFICA1 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, cat.categoria as categoria, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    public static final String IJ_CARRITO_ORDEN = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra";
    public static final String IJ_ANUNCIO_CARRITO = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";
    public static final String IJ_CATEGORIA_ANUNCIO = " inner join petstore.categoria as cat on cat.id = anuncio.id_categoria";
    public static final String GROUP_CATEGORIA_M_A = " group by anio, mes, categoria";
    public static final String CAMPOS_GRAFICA2 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    public static final String GROUP_MES_ANIO = " group by anio, mes";

}
