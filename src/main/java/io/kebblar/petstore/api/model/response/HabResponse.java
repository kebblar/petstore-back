package io.kebblar.petstore.api.model.response;

public class HabResponse {
    private int id;
    private String label;
    private int val;
    public HabResponse() {
    }
    public HabResponse(int id, String label, int val) {
        this.id = id;
        this.label = label;
        this.val = val;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "HabilidadResponse [getId()=" + getId() + ", getLabel()=" + getLabel() + ", getVal()=" + getVal() + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + val;
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
        HabResponse other = (HabResponse) obj;
        if (id != other.id)
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (val != other.val)
            return false;
        return true;
    }

}
