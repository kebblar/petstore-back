package io.kebblar.petstore.api.model.response;

import java.util.List;

public class CategoriaAtributoList {
    private int[] seleccion;
    private List<DataElement> data;
    
    public CategoriaAtributoList() {}
    
    public CategoriaAtributoList(List<DataElement> data) {
        this.seleccion = new int[data.size()];
        this.data = data;
    }
    
    public int[] getSeleccion() {
        return this.seleccion;
    }

    public List<DataElement> getData() {
        return data;
    }

    public void setSeleccion(int[] seleccion) {
        this.seleccion = seleccion;
    }

    public void setData(List<DataElement> data) {
        this.data = data;
    }

}




/*

        {
            "ordinal":0, 
            "cabecera": {
                "id": "radio-group-0", 
                "name": "radio-options-0", 
                "idacc":"accordion-0", 
                "desc": "Estatura", 
                "longdesc":"Por favor, selecciona tu estaturaX"
            },
            "contenido":[
                { "leyenda": "No deseo indicar mi Estatura", "valor": 0 },
                { "leyenda": "Menor a 1 metro y 40 centimetros", "valor": 1 },
                { "leyenda": "Entre 140 y 145", "valor": 2 },
                { "leyenda": "Entre 145 y 155", "valor": 3 },
                { "leyenda": "Entre 155 y 165", "valor": 4 },
                { "leyenda": "Entre 165 y 175", "valor": 5 },
                { "leyenda": "Entre 175 y 190", "valor": 6 },
                { "leyenda": "Mayor a 1 metro y 90 centimetros", "valor": 7}
            ]
        }

*/