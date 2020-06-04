package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Articulo;
import model.Compra;
import model.Usuario;

public class UsuarioDao {
	private DbConnection conn;

	public UsuarioDao(DbConnection conn) {
		super();
		this.conn = conn;
	}

	public Usuario logueo(String email, String pass) {
		String sql = "select * from eusuario where asemail=? and ascontrasenia=md5(?) ";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario user = new Usuario(rs.getInt(1));
				user.setNombre(rs.getString(2));
				user.setApellido(rs.getString(3));
				user.setEmail(email);
				user.setDireccion(rs.getString(6));
				user.setTelefono(rs.getString(7));
				user.setFechaReg(rs.getString(8));
				return user;
			} else {
				System.out.println("log erroneo");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error en la consulta de log");
			return null;
		}

	}

	public boolean existeUsuario(String email) {
		String sql = "select * from eusuario where asemail=?";

		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void registraNuevoUsuario(Usuario usu) {
		String sql = "insert into eusuario (asnombre,asapeliido,asemail,ascontrasenia,asdireccion,astelefono,adfechareg,ahhorareg) values(?,?,?,md5(?),?,?,?,?)";

		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, usu.getNombre());
			ps.setString(2, usu.getApellido());
			ps.setString(3, usu.getEmail());
			ps.setString(4, usu.getContrasenia());
			ps.setString(5, usu.getDireccion());
			ps.setString(6, usu.getTelefono());
			ps.setString(7, usu.getFechaReg());
			ps.setString(8, usu.getHoraReg());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error al insertar usuario");
			e.printStackTrace();
		}

	}

	public void actualizaUsuario(Usuario usu) {
		String sql = "update eusuario set asnombre=?, asapeliido=?, asdireccion=?, astelefono=? where k=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, usu.getNombre());
			ps.setString(2, usu.getApellido());
			ps.setString(3, usu.getDireccion());
			ps.setString(4, usu.getTelefono());

			ps.setInt(5, usu.getK());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error al actualizar usuario");
			e.printStackTrace();
		}

	}

	public ArrayList<Compra> getComprasSimple(int k) {

		ArrayList<Compra> compras = new ArrayList<Compra>();
		String sql = "select * from eventa where xusuario=?";
		Compra compra;
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, k);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				compra = new Compra();
				compra.setId(rs.getInt(1));
				compra.setPrecio(rs.getDouble(3));
				compra.setFecha(rs.getString(4));
				compra.setHora(rs.getString(5));
				compras.add(compra);
				System.out.println(compra);
			}

			rs.close();
			ps.close();
			return compras;

		} catch (SQLException e) {
			System.out.println("error al cargar las compras");
			e.printStackTrace();
		}

		return null;
	}

	public Compra getCompra(int idVenta) {

		String sql = "select P.asnombre, P.afprecioKG, ER.afkg , ER.afcoste " + 
				"from erventaproducto as ER, eproducto as P " + 
				"where xventa=? and P.k=ER.xproducto";
		Compra compra= new Compra();
		
		
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, idVenta);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+ rs.getDouble(2)+ rs.getDouble(3)+ rs.getDouble(4));
				compra.getArts().add(new Articulo(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4)));
				
			}

			rs.close();
			ps.close();
			return compra;

		} catch (SQLException e) {
			System.out.println("error al cargar las compras");
			e.printStackTrace();
		}
		
		

		return null;
	}

}
