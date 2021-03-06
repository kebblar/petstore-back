/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   CategoriaServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (00_02)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_0002 Implementación de clase
 *
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.domain.AtributoTO;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.CategoriaDetallesTO;
import io.kebblar.petstore.api.model.domain.CategoriaTO;
import io.kebblar.petstore.api.model.domain.ValorAtributo;
import io.kebblar.petstore.api.mapper.CategoriaMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'categoria'.
 *
 * <p>Implementación de la interfaz {@link CategoriaService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.Categoria
 * @see  io.kebblar.petstore.api.service.CategoriaService
 */
@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaServiceImpl.class);

    private CategoriaMapper categoriaMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param categoriaMapper mapper utilizado para llamar a metodos de persistencia
     */
    public CategoriaServiceImpl(CategoriaMapper categoriaMapper) {
        logger.info("Invoking CategoriaServiceImpl constructor");
        this.categoriaMapper = categoriaMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public Categoria getById(int id) throws BusinessException {
        try {
            return categoriaMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<Categoria> getAll() throws BusinessException {
        try {
            /** /
            System.out.println("Tamaño: "+ categoriaMapper.getAllCategoriaDetalle().size());
            for (CategoriaDetallesTO c: categoriaMapper.getAllCategoriaDetalle()) {
                System.out.println(c.toString());
            }
            getAllCategoriaDetalles();
            /**/
            return categoriaMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(Categoria categoria) throws BusinessException {
        try {
            return categoriaMapper.insert(categoria);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(Categoria categoria) throws BusinessException {
        try {
            return categoriaMapper.update(categoria);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(Categoria categoria) throws BusinessException {
        try {
            return categoriaMapper.delete(categoria.getId());
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(Categoria categoria) throws BusinessException {
        try {
            if (getById(categoria.getId()) == null) {
                return categoriaMapper.insert(categoria);
            } else {
                return categoriaMapper.update(categoria);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<Categoria> getByNombre(String nombre) throws BusinessException {
        try {
            return categoriaMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<CategoriaTO> getAllCategoriaDetalles() throws BusinessException {
        try {
            //System.out.println("Tamaño: "+ categoriaMapper.getAllCategoriaDetalle().size());
            List<CategoriaTO> ct = new ArrayList<>();
            Map<Integer, CategoriaTO> map = new HashMap<Integer, CategoriaTO>();
           // Map<Integer, List<AtributoTO>> mapA = new HashMap<Integer, List<AtributoTO>>();
            //Map<Integer, List<ValorAtributo>> mapVA = new HashMap<Integer, List<ValorAtributo>>();

            for (CategoriaDetallesTO c: categoriaMapper.getAllCategoriaDetalle()) {
                if(map.containsKey(c.getIdCategoria())) {
                    //if(mapA.containsKey(c.getIdCategoria())) {
                        try {
                            if(c.getId_atributo()>0) {
                                //List<AtributoTO> a = mapA.get(c.getIdCategoria());
                                List<AtributoTO> a = map.get(c.getIdCategoria()).getAtributos();
                                AtributoTO aux = new AtributoTO(c.getId_atributo(),c.getNombreAtributo(),c.getEstatusAtributo());
                                Boolean agregarAtributo = true;
                                for (int i = 0; i < a.size(); i++) {

                                    if(a.get(i).getId() == aux.getId() ) {
                                        agregarAtributo = false;
                                        ValorAtributo auxVa = new ValorAtributo(c.getIdRango(),c.getRangoIdAtributo(),c.getRango(),c.getEstatusRango());
                                        a.get(i).getRangos().add(auxVa);
                                        map.get(c.getIdCategoria()).setAtributos(a);
                                        break;
                                    }
                                }

                                if(agregarAtributo) {
                                    //mapVA.get(c.getIdCategoria()).add(auxVa);
                                    List<ValorAtributo> va = new ArrayList<ValorAtributo>();
                                    //ValorAtributo auxVa = new ValorAtributo(c.getIdRango(),c.getRangoIdAtributo(),c.getRango(),c.getEstatusRango());
                                    aux.setRangos(va);
                                    map.get(c.getIdCategoria()).getAtributos().add(aux);

                                }
                             /*
                                if(mapVA.containsKey(c.getIdCategoria())) {
                                    List<ValorAtributo> va = mapVA.get(c.getIdCategoria());
                                    ValorAtributo auxVa = new ValorAtributo(c.getIdRango(),c.getRangoIdAtributo(),c.getRango(),c.getEstatusRango());
                                    Boolean agregar = true;
                                    for (ValorAtributo lis : va) {
                                        if(lis.getId() == auxVa.getId() ) {
                                            agregar = false;
                                            break;
                                        }
                                    }

                                }

                                if(agregarAtributo) {
                                    //mapA.get(c.getIdCategoria()).add(aux);
                                    a.add(aux);
                                }
                                */
                            }
                        }  catch (Exception e) {

                        }
                    //}


                } else {
                    CategoriaTO cto = new CategoriaTO();
                    Categoria cat = new Categoria(c.getIdCategoria(),c.getCategoriaNombre(),c.getEstatusCategoria());
                    List<AtributoTO> la = new ArrayList<>();

                    try {
                        if (c.getId_categoria()> 0) {
                            AtributoTO a = new AtributoTO(c.getId_atributo(),c.getNombreAtributo(),c.getEstatusAtributo());
                                                        //la.add(a);
                            //mapA.put(c.getId_categoria(), la);

                             if(c.getIdRango() > 0) {
                                 List<ValorAtributo> lva = new ArrayList<>();
                                 ValorAtributo va = new ValorAtributo(c.getIdRango(),c.getRangoIdAtributo(),c.getRango(),c.getEstatusRango());
                                 lva.add(va);
                                 a.setRangos(lva);
                                 //mapVA.put(c.getId_categoria(), lva);
                             }
                             la.add(a);
                        }
                    } catch (Exception e) {
                        logger.error("Excepción NO tratada");
                        logger.error(e.getMessage());
                    }
                    cto.setCategoria(cat);
                    cto.setAtributos(la);
                    map.put(c.getIdCategoria(), cto);
                }
                //System.out.println(c.toString());
            }

            for (Integer key : map.keySet()) {
                CategoriaTO value = map.get(key);
               ct.add(value);
            }


            return ct;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
