package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.Factura;

@Repository
public interface FacturaMapper {
	
	public final String FACTURA_FIELDS = "id, fecha, cliente_rfc, id_producto, precio, iva";
	
	// métodos de persistencia (select, insert, update, delete, findPrimaryKey)

	@Results(id="FacturaResultMaps", value = {
			@Result(property = "id",         column= "id"),
			@Result(property = "fecha",      column= "fecha"),
			@Result(property = "clienteRfc", column= "cliente_rfc"),
			@Result(property = "idProducto", column= "id_producto"),
			@Result(property = "precio",     column= "precio"),
			@Result(property = "iva",        column= "iva")
	})
	@Select("select "+FACTURA_FIELDS+" FROM factura")
	List<Factura> getAll() throws SQLException;

	@Insert("insert into factura ()fecha, cliente_rfc, id_producto, precio, iva) values (#{fecha}, #{clienteRfc}, #{idProducto}, #{precio}, #{iva})")
	int insert(Factura factura) throws SQLException;

	@Update("update factura SET idProducto=#{idProducto} WHERE id=#{id}")
	int update(Factura factura) throws SQLException;

	@Delete("delete FROM factura where id=#{id}")
	int delete(int id) throws SQLException;

	@Select("select "+FACTURA_FIELDS+" FROM factura WHERE idProducto=#{id}")
	List<Factura> findByIdProd(int idProd) throws SQLException;

	@Select("select "+FACTURA_FIELDS+" FROM factura WHERE idProducto=#{key}")
	Factura findByIdprimaryKey(int key) throws SQLException;

	/*
	 * CREATE TABLE factura( id int(11) NOT NULL AUTO_INCREMENT, fecha date NOT
	 * NULL, cliente_rfc varchar(13) not null, id_producto int(11) not null, precio
	 * double not null, iva int(11) not null, PRIMARY KEY (id) );
	 * 
	 */
}
