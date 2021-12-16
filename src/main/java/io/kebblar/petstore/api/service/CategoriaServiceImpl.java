package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.kebblar.petstore.api.mapper.CategoriaMapper;
import io.kebblar.petstore.api.model.domain.CategAtt;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.response.Cabecera;
import io.kebblar.petstore.api.model.response.CategoriaAtributoList;
import io.kebblar.petstore.api.model.response.ContenidoDetalle;
import io.kebblar.petstore.api.model.response.DataElement;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private CategoriaMapper categoriaMapper;
    
    public CategoriaServiceImpl(CategoriaMapper categoriaMapper) {
        this.categoriaMapper = categoriaMapper;
    }
    @Override
    public CategoriaAtributoList buildList() {
        try {
            CategoriaAtributoList r = buildList3();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(r);
            System.out.println(jsonString);
            return r;
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private CategoriaAtributoList buildList3() throws SQLException {
        List<Categoria> lista = categoriaMapper.getAll();
        List<DataElement> data = new  ArrayList<>();
        
        for(Categoria categoria : lista) {
            Cabecera cabecera = new Cabecera(
                    "radio-group-"+categoria.getId(), 
                    "radio-options-"+categoria.getId(), 
                    "accordion-"+categoria.getId(), 
                    categoria.getNombre(), 
                    categoria.getDescripcion()
                );
            
            List<CategAtt> att = categoriaMapper.getCategAppById(categoria.getId());
            List<ContenidoDetalle> contenido = new  ArrayList<>();
            
            int i=1;
            for(CategAtt detalle : att) {
                contenido.add(new ContenidoDetalle(i++, detalle.getLeyenda()));
            }
            
            data.add(new DataElement(categoria.getId(), cabecera, contenido));
        }
        return new CategoriaAtributoList(data);
    }
    
    
    /*
    public CategoriaAtributoList buildList2() {
        ContenidoDetalle contenido = null;
        DataElement dataElement = null;
        try {
            
            List<Categoria> lista = categoriaMapper.getAll();
            List<CategoriaAtributoList> grupo = new  ArrayList<>();
            
            for(Categoria cat : lista) {
                int ordinal = cat.getId();
                Cabecera cabecera = new Cabecera(cat.getId(), cat.getNombre(), 1, "","");
                
                List<CategAtt> att = categoriaMapper.getCategAppById(ordinal);
                List<ContenidoDetalle> cnt = new ArrayList<>();
                
                for(CategAtt catAtt : att) {
                    cnt.add(new ContenidoDetalle(catAtt.getId(), catAtt.getLeyenda()));
                }
                
            }
            List<DataElement> gus;
            return new CategoriaAtributoList(lista.size(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }*/

}
