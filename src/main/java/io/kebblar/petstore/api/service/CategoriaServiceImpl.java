/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CategoriaServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:25
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
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.CategoriaService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
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
    /** {@inheritDoc} */
    @Override
    public Categoria getById(int id) throws BusinessException {
        try {
            return categoriaMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /*
    * Implementación del método getAll
    */
    /** {@inheritDoc} */
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
            throw new DatabaseException(e);
        }
    }

    /*
    * Implementación del método insert
    */
    /** {@inheritDoc} */
    @Override
    public int insert(Categoria categoria) throws BusinessException {
        try {
            return categoriaMapper.insert(categoria);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /*
    * Implementación del método update
    */
    /** {@inheritDoc} */
    @Override
    public int update(Categoria categoria) throws BusinessException {
        try {
            return categoriaMapper.update(categoria);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /*
    * Implementación del método delete
    */
    /** {@inheritDoc} */
    @Override
    public int delete(Categoria categoria) throws BusinessException {
        try {
            return categoriaMapper.delete(categoria.getId());
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /*
    * Implementación del método save
    */
    /** {@inheritDoc} */
    @Override
    public int save(Categoria categoria) throws BusinessException {
        try {
            if (getById(categoria.getId()) == null) {
                return categoriaMapper.insert(categoria);
            } else {
                return categoriaMapper.update(categoria);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Categoria> getByNombre(String nombre) throws BusinessException {
        try {
            return categoriaMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /*
    * Implementación del método getAll
    */
    /** {@inheritDoc} */
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
                            if(c.getIdAtrib()>0) {
                                //List<AtributoTO> a = mapA.get(c.getIdCategoria());
                                List<AtributoTO> a = map.get(c.getIdCategoria()).getAtributos();
                                AtributoTO aux = new AtributoTO(c.getIdAtrib(),c.getNombreAtributo(),c.getEstatusAtributo());
                                Boolean agregarAtributo = true;
                                for (int i = 0; i < a.size(); i++) {

                                    if(a.get(i).getId().intValue() == aux.getId().intValue() ) {
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
                        if (c.getIdCateg()> 0) {
                            AtributoTO a = new AtributoTO(c.getIdAtrib(),c.getNombreAtributo(),c.getEstatusAtributo());
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
            throw new DatabaseException(e);
        }
    }
}
