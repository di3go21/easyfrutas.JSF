package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarritoDao;
import dao.DbConnection;
import dao.UsuarioDao;
import model.Carrito;
import model.Compra;
import model.Usuario;

/**
 * Servlet implementation class ZonaUsuario
 */
@WebServlet("/ZonaUsuario")
public class ZonaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZonaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		Carrito carrito = new Carrito();

		if (accion.contentEquals("addProd")) {
			int k = Integer.valueOf(request.getParameter("idprod"));
			double cant = Double.valueOf(request.getParameter("cantidad"));
			if (request.getSession().getAttribute("carrito") != null) {

				carrito = (Carrito) request.getSession().getAttribute("carrito");
				carrito.addCantidad(k, cant);

				request.getSession().setAttribute("carrito", carrito);

			} else {

				carrito.addCantidad(k, cant);
				request.getSession().setAttribute("carrito", carrito);

			}
			if ((request.getSession().getAttribute("userLoged")) != null) {

				DbConnection conn = new DbConnection();
				CarritoDao carDao = new CarritoDao(conn);
				int idUsuario = Integer.valueOf(((Usuario) request.getSession().getAttribute("userLoged")).getK());

				carDao.guardaCarrito(carrito, idUsuario);
				conn.disconnect();

			}

			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} else if (accion.contentEquals("verCarrito")) {
			request.getRequestDispatcher("/verCarrito.jsp").forward(request, response);
			
		} else if (accion.contentEquals("personal")) {
			DbConnection conn=new DbConnection();
			UsuarioDao usuDao = new UsuarioDao(conn);
			ArrayList<Compra> compras= new ArrayList<Compra>();
			Usuario user=(Usuario)request.getSession().getAttribute("userLoged");
			compras = usuDao.getComprasSimple(user.getK());
			request.getSession().setAttribute("compras", compras);				

			request.getRequestDispatcher("/personal.jsp").forward(request, response);
		}  else if(accion.contentEquals("verCompra")) {
			DbConnection conn=new DbConnection();
			UsuarioDao usuDao = new UsuarioDao(conn);
			System.out.println(Integer.valueOf(request.getParameter("id")));
			Compra compra = usuDao.getCompra(Integer.valueOf(request.getParameter("id")));
			compra.setFecha(request.getParameter("fecha"));
			compra.setHora(request.getParameter("hora"));
			compra.setId(Integer.valueOf(request.getParameter("id")));
			compra.setPrecio(Double.valueOf(request.getParameter("precio")));
			request.setAttribute("compra", compra);
			request.getRequestDispatcher("/infoCompra.jsp").forward(request, response);
		}
		
		
		
		else if (accion.contentEquals("modificarDatos")) {
			request.getRequestDispatcher("/modificarDatos.jsp").forward(request, response);
		} else if (accion.contentEquals("preCompra")) {
			request.getRequestDispatcher("/preCompra.jsp").forward(request, response);
		} else if (accion.contentEquals("okCompra")) {

			DbConnection conn = new DbConnection();
			CarritoDao cartDao = new CarritoDao(conn);
			carrito = (Carrito) request.getSession().getAttribute("carrito");
			int k = ((Usuario) request.getSession().getAttribute("userLoged")).getK();
			cartDao.procesaCompra(carrito, k);

			request.getSession().setAttribute("carrito", new Carrito());

			request.getRequestDispatcher("/compraOK.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("accion").contentEquals("actualizaDatos")) {
			Usuario user = (Usuario) request.getSession().getAttribute("userLoged");
			user.setNombre(request.getParameter("nombre"));
			user.setApellido(request.getParameter("apellido"));
			user.setDireccion(request.getParameter("direccion"));
			user.setTelefono(request.getParameter("telefono"));
			request.getSession().setAttribute("userLoged", user);

			DbConnection conn = new DbConnection();
			UsuarioDao usuDao = new UsuarioDao(conn);
			usuDao.actualizaUsuario(user);
			conn.disconnect();

		}

		request.getRequestDispatcher("/modificacionOK.jsp").forward(request, response);
	}

}
