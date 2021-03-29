package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.Factura;

@Repository
public interface FacturaMapper {

	static final String FACTURA_FIELDS = "id, fecha, cliente_rfc, id_producto, precio, iva";
	
	@Results(id="FacuturaResultMap",value = {
			@Result(property ="id",            column="id"),
			@Result(property ="fecha",         column="fecha"),
			@Result(property ="clienteRfc",    column="cliente_rfc"),
			@Result(property ="idProducto",    column="id_producto"),
			@Result(property ="precio",    column="precio"),
			@Result(property ="iva",    column="iva"),})
	@Select("SELECT " + FACTURA_FIELDS +" FROM factura")
	List<Factura> getAll() throws SQLException;
	
	@Insert("INSERT INTO factura (" + FACTURA_FIELDS +"  ) VALUES (#{fecha},#{clienteRfc},#{idProducto},#{precio},#{iva}")
	int insert(Factura factura) throws SQLException;
	
	@Update("UPDATE factura SET fecha = #{fecha}, clienteRFC=#{clienteRfc}, idProducto=#{idProducto}, precio=#{precio}, iva=#{iva} WHERE id=#{id}")
	int update (Factura factura) throws SQLException;
	
	@Delete("DELETE FROM factura WHERE id=#{id}")
	int delete(int id) throws SQLException;
	
	@ResultMap("FacuturaResultMap")
	@Select("SELECT "+ FACTURA_FIELDS +" FROM factura WHERE idProducto=#{idProd}")
	List<Factura> findByIdProd(int idProd) throws SQLException;
	
	@ResultMap("FacuturaResultMap")
	@Select("SELECT "+ FACTURA_FIELDS +" FROM factura WHERE id=#{key}")
	List<Factura> findByIdPrimaryKey(int key) throws SQLException;
}
