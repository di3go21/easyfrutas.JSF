package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnection;
import dao.ProductoDao;
import model.Producto;

/**
 * Servlet implementation class ControladorPrincipal
 */
@WebServlet("/ControladorPrincipal")
public class ControladorPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorPrincipal() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqdis;
		DbConnection conn=new DbConnection();
		ProductoDao proDAo = new ProductoDao(conn);
		List<Producto> lista = new ArrayList<>();
		HttpSession misesion= request.getSession();
		
		lista = proDAo.dameProductos();
		conn.disconnect();
		misesion.setAttribute("listaProductos", lista);
		reqdis = request.getRequestDispatcher("/index.jsp");
		reqdis.forward(request, response);

	
		
		doPost(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("holaaa");
	}


	

	

}
