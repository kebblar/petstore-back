package io.kebblar.petstore.api.model.domain;

public class Consulta {
	private int id;
	private int selected;
	
	public Consulta() {}
	
	public Consulta(int id, int selected) {
		this.id = id;
		this.selected = selected;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}
	
}
