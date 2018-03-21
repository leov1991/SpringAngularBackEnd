package com.demo.model;

import javax.persistence.Table;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name= "users")
@Access(AccessType.FIELD)
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name="nombre", nullable= false, length=45)
	private String nombre;
	
	@Column(name="apellido", nullable= false, length=45)
	private String apellido;
	
	@Column(name="email", nullable= false, length=45)
	private String email;
	
	@Column(name="telefono", nullable= true, length=45)
	private String telefono;
	
	@Column(name="direccion", nullable= true, length=45)
	private String direccion;
	
	@Column(name="ciudad", nullable= true, length=45)
	private String ciudad;
	
	@Column(name="cod_postal", nullable= true, length=45)
	private String codPostal;
	
	
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String cod_postal) {
		this.codPostal = cod_postal;
	}
	

}
