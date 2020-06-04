package model;

import java.util.ArrayList;

public class Compra {

		private ArrayList<Articulo> arts;
		private String fecha;
		private String hora;
		private double precio;
		private int id;
		public ArrayList<Articulo> getArts() {
			return arts;
		}
		public void setArts(ArrayList<Articulo> arts) {
			this.arts = arts;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Compra() {
			super();
			this.arts= new ArrayList<Articulo>();
		}
		@Override
		public String toString() {
			return "Compra [arts=" + arts + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + ", id=" + id
					+ "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((arts == null) ? 0 : arts.hashCode());
			result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
			result = prime * result + ((hora == null) ? 0 : hora.hashCode());
			result = prime * result + id;
			long temp;
			temp = Double.doubleToLongBits(precio);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Compra other = (Compra) obj;
			if (arts == null) {
				if (other.arts != null)
					return false;
			} else if (!arts.equals(other.arts))
				return false;
			if (fecha == null) {
				if (other.fecha != null)
					return false;
			} else if (!fecha.equals(other.fecha))
				return false;
			if (hora == null) {
				if (other.hora != null)
					return false;
			} else if (!hora.equals(other.hora))
				return false;
			if (id != other.id)
				return false;
			if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
				return false;
			return true;
		}
		
		
		
		
		
}
