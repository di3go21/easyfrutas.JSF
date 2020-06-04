package model;

import java.util.List;

public class Venta {

	private int k;
	private Usuario usuario;
	private List<Articulo> listaArt;
	private double preciototal;

	public Venta(int k) {
		super();
		this.k = k;
	}

	public Venta(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Articulo> getListaArt() {
		return listaArt;
	}

	public void setListaArt(List<Articulo> listaArt) {
		this.listaArt = listaArt;
	}

	public void actualizaPrecioTotal() {
		double total = 0;
		for (Articulo articulo : listaArt) {
			total += articulo.getCoste();
		}
		this.preciototal = total;
	}

	public double getPreciototal() {
		return preciototal;

	}

	@Override
	public String toString() {
		return "Venta [k=" + k + ", usuario=" + usuario + ", listaArt=" + listaArt + ", preciototal=" + preciototal
				+ "]";
	}
}
