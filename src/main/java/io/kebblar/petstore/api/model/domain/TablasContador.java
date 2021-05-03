package io.kebblar.petstore.api.model.domain;

public enum TablasContador {
    PAISES("pais"),
    ESTADOS("estado"),
    MUNICIPIOS("municipio");

    private final String tabla;

    TablasContador(String tabla) {
        this.tabla = tabla;
    }

    public String getTabla() {
        return tabla;
    }
}
