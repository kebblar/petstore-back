package io.kebblar.petstore.api.model.domain;

public enum TablasContador {

    /*
     * Enums.
     */
    PAISES("pais"),
    ESTADOS("estado"),
    MUNICIPIOS("municipio");

    private final String tabla;

    /**
     * Constructor.
     */
    TablasContador(String tabla) {
        this.tabla = tabla;
    }

    /**
     * Getter.
     */
    public String getTabla() {
        return tabla;
    }
}
