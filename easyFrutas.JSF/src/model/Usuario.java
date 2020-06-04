package model;

import util.Fecha;
import util.Hora;

public class Usuario {

	private int k;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private String direccion;
	private String telefono;
	private String fechaReg;
	private String horaReg;

	public Usuario(int k) {
		super();
		this.k = k;
	}

	public Usuario(String email) {
		super();
		this.email = email;
		this.fechaReg = Fecha.fechaActual();
		this.horaReg = Hora.horaActual();
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getHoraReg() {
		return horaReg;
	}

	public void setHoraReg(String horaReg) {
		this.horaReg = horaReg;
	}

	@Override
	public String toString() {
		return "Usuario [k=" + k + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaReg="
				+ fechaReg + ", horaReg=" + horaReg + "]";
	}
}
