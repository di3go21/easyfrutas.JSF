package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.CarritoDao;
import dao.DbConnection;
import dao.ProductoDao;
import dao.UsuarioDao;
import model.Carrito;
import model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.contentEquals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("ControladorPrincipal").forward(request, response);

		} else if (action.contentEquals("login")) {

			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String psw = request.getParameter("password");

		HttpSession session = request.getSession();
		RequestDispatcher reqdis;
		Usuario user;
		DbConnection conn = new DbConnection();
		UsuarioDao usuDao = new UsuarioDao(conn);
		user = usuDao.logueo(email, psw);
		conn.disconnect();
		if (user != null) {
			session.setAttribute("userLoged", user);
			session.setAttribute("idUsuario", user.getK());
			conn= new DbConnection();
			CarritoDao cartDao = new CarritoDao(conn);
			Carrito cart= cartDao.recuperaCarrito(user.getK());
			
			
			session.setAttribute("carrito", cart);
			conn.disconnect();
			
			
			reqdis = request.getRequestDispatcher("/index.jsp");
			reqdis.forward(request, response);
		} else {
			String msg = "Email o contraseña incorrecto";
			request.setAttribute("logFailed", msg);
			reqdis = request.getRequestDispatcher("/index.jsp");
			reqdis.forward(request, response);

		}

	}

}
