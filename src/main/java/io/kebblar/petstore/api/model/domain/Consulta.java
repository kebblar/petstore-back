package io.kebblar.petstore.api.model.domain;

public class Consulta {
    private int idUsuario;
	private int idCombo;
	private int idOpcion;
	
	public Consulta() {}

    public Consulta(int idUsuario, int idCombo, int idOpcion) {
        this.idUsuario = idUsuario;
        this.idCombo = idCombo;
        this.idOpcion = idOpcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

}
