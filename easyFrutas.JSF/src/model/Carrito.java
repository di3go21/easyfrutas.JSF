package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import dao.DbConnection;
import util.Numero;

public class Carrito {

	private HashMap<Integer, Double> carrito;

	public HashMap<Integer, Double> getCarrito() {
		return carrito;
	}

	public void setCarrito(HashMap<Integer, Double> carrito) {
		this.carrito = carrito;
	}

	public Carrito(HashMap<Integer, Double> carrito) {
		super();
		this.carrito = carrito;
	}

	public void addCantidad(int k, double cant) {
		Double anterior = 0.0;
		try {
			anterior = this.carrito.get(k);
		} catch (NullPointerException e) {

		}
		if (anterior == null)
			this.carrito.put(k, (cant));
		else {
			this.carrito.put(k, (cant+anterior));
		}

	}

	@Override
	public String toString() {
		return "Carrito [carrito=" + carrito + "]";
	}

	public Carrito() {
		super();
		this.carrito = new HashMap<Integer, Double>();

	}
	public Double getTotal() {
		DbConnection conn = new DbConnection();
		double total=0.0;
		double precioUni=0.0;
		String precio="select afprecioKG from eproducto where k=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(precio);
			ResultSet rs=null;
			
			for (Map.Entry<Integer, Double> entry : this.getCarrito().entrySet()) {
				ps.setInt(1, entry.getKey());
				rs= ps.executeQuery();
				rs.next();
				precioUni=rs.getDouble(1);
				total+= Numero.dosDecimales(precioUni*entry.getValue());
			}
			rs.close();
			ps.close();
			conn.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return Numero.dosDecimales(total);
	}

	

}
