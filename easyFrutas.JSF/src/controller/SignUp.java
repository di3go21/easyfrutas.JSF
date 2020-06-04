package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.UsuarioDao;
import model.Usuario;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
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
		RequestDispatcher rd;
		Usuario usu;
		if (action.contentEquals("nuevoReg")) {
			rd = request.getRequestDispatcher("/Registro.html");
			rd.forward(request, response);
		} else if (action.contentEquals("formRelleno")) {
			String email = request.getParameter("email");
			DbConnection conn = new DbConnection();
			UsuarioDao usuDao = new UsuarioDao(conn);

			if (!usuDao.existeUsuario(email)) {
				usu = new Usuario(request.getParameter("email"));
				usu.setApellido(request.getParameter("apellido"));
				usu.setNombre(request.getParameter("nombre"));
				usu.setContrasenia(request.getParameter("password"));
				usu.setDireccion(request.getParameter("direccion"));
				usu.setTelefono(request.getParameter("telefono"));
				usuDao.registraNuevoUsuario(usu);
				System.out.println(usu);
				conn.disconnect();
				request.setAttribute("nombre", request.getParameter("nombre"));
				request.setAttribute("apellido", request.getParameter("apellido"));
				
				rd = request.getRequestDispatcher("/RegistroOK.jsp");
				rd.forward(request, response);
				System.out.println("imprime despues de fordward?");
			} else {
				conn.disconnect();
				request.setAttribute("email", request.getParameter("email"));
				rd = request.getRequestDispatcher("/UsuarioExistente.jsp");
				rd.forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
