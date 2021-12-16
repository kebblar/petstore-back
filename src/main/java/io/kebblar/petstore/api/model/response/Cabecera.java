package io.kebblar.petstore.api.model.response;

public class Cabecera {
    private String id;
    private String name;
    private String idacc;
    private String desc;
    private String longdesc;
    public Cabecera() {}
    public Cabecera(String id, String name, String idacc, String desc, String longdesc) {
        this.id = id;
        this.name = name;
        this.idacc = idacc;
        this.desc = desc;
        this.longdesc = longdesc;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdacc() {
        return idacc;
    }
    public void setIdacc(String idacc) {
        this.idacc = idacc;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getLongdesc() {
        return longdesc;
    }
    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }
    
}
