package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoDao {
	
	private DbConnection conn;

	public ProductoDao(DbConnection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Producto> dameProductos(){
		
		List<Producto> lista=new ArrayList<Producto>();
		String sql="select * from eproducto";
		
		try {
			PreparedStatement ps= this.conn.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			Producto prod;
			while(rs.next()) {
				prod= new Producto(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setPrecio(rs.getDouble(3));
				prod.setStock(rs.getDouble(4));
				lista.add(prod);
			}
			
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	

}
