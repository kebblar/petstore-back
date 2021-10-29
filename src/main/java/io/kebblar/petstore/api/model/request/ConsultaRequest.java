package io.kebblar.petstore.api.model.request;

public class ConsultaRequest {
    private int id;
    private int selected;
    
    public ConsultaRequest() {}
    
    public ConsultaRequest(int id, int selected) {
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
