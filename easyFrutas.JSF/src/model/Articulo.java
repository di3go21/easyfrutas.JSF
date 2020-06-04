package model;

public class Articulo {
	
	private String articulo;
	private double precioKG;
	private double cantidad;
	private double coste;
	public Articulo(String articulo, double precioKG, double cantidad, double coste) {
		super();
		this.articulo = articulo;
		this.precioKG = precioKG;
		this.cantidad = cantidad;
		this.coste = coste;
	}
	@Override
	public String toString() {
		return "Articulo [articulo=" + articulo + ", precioKG=" + precioKG + ", cantidad=" + cantidad + ", coste="
				+ coste + "]";
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public double getPrecioKG() {
		return precioKG;
	}
	public void setPrecioKG(double precioKG) {
		this.precioKG = precioKG;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	
	
	
	
	
	
	

}
