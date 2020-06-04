package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import model.Carrito;
import model.Compra;
import util.Fecha;
import util.Hora;

public class CarritoDao {

	private DbConnection conn;

	public CarritoDao(DbConnection conn) {
		super();
		this.conn = conn;
	}

	public Carrito recuperaCarrito(int k) {

		String consulta = "select * from ecarrito where xusuario=?";
		try {
			PreparedStatement ps = this.conn.getConnection().prepareStatement(consulta);
			ps.setInt(1, k);
			ResultSet rs = ps.executeQuery();
			Carrito cart = new Carrito();
			while (rs.next()) {
				cart.addCantidad(rs.getInt(2), rs.getDouble(3));
			}

			return cart;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void guardaCarrito(Carrito cart, int k) {

		String consultaBorrar = "delete from ecarrito where xusuario=?";
		String consultaAddCarrito = "insert into ecarrito values (?,?,?)";

		try {
			PreparedStatement ps = this.conn.getConnection().prepareStatement(consultaBorrar);
			ps.setInt(1, k);
			ps.execute();

			ps = this.conn.getConnection().prepareStatement(consultaAddCarrito);
			ps.setInt(1, k);

			for (Map.Entry<Integer, Double> entry : cart.getCarrito().entrySet()) {
				ps.setInt(2, entry.getKey());

				ps.setDouble(3, entry.getValue());
				ps.execute();
				System.out.println("insert "+k+" "+entry.getKey()+" "+entry.getValue());
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void procesaCompra(Carrito carrito, int k) {
		
		String insertV=" insert into eventa (xusuario,afpreciototal,adfecha,athora) values (?,?,?,?)";
		String insertER="insert into erventaproducto values ((select k from eventa where adfecha=? and athora=?),?,?,round((?*(select afprecioKG from eproducto where k=?)),2))";
		String delete = "delete from ecarrito  where xusuario=?";
	
		try {
			PreparedStatement ps = this.conn.getConnection().prepareStatement(insertV);
			PreparedStatement ps2 = this.conn.getConnection().prepareStatement(insertER);
			PreparedStatement ps3= this.conn.getConnection().prepareStatement(delete);
			String hora=Hora.horaActual();
			ps.setInt(1, k);
			ps.setDouble(2, carrito.getTotal());
			ps.setString(3, Fecha.fechaActual());
			ps.setString(4, hora);
			ps.execute();
			
			for (Map.Entry<Integer, Double> entry : carrito.getCarrito().entrySet()) {
				ps2.setString(1, Fecha.fechaActual());
				ps2.setString(2,hora);
				ps2.setInt(3, entry.getKey());
				ps2.setDouble(4,entry.getValue());
				ps2.setDouble(5,entry.getValue());
				ps2.setDouble(5,entry.getValue());
				ps2.setInt(6,entry.getKey());
				ps2.execute();
			}
			ps3.setInt(1, k);
			ps3.execute();
			
			ps3.close();
			ps2.close();
			ps.close();
		

			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
