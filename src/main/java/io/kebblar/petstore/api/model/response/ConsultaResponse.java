package io.kebblar.petstore.api.model.response;

public class ConsultaResponse {
    private int id;
    private int selected;
    
    public ConsultaResponse() {}
    
    public ConsultaResponse(int id, int selected) {
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
