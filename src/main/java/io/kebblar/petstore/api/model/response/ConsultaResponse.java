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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + selected;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConsultaResponse other = (ConsultaResponse) obj;
        if (id != other.id)
            return false;
        if (selected != other.selected)
            return false;
        return true;
    }

    public int getHash() {
        return this.hashCode();
    }

}
