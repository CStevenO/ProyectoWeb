package com.steven.ProyectoWeb.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_Agencia")
public class MAgencia {
	@Id
	@Column(unique = true, nullable = false)
	private Long id;
	private String agNombre;
	private String agTelefono;
	private String agDireccion;
	public MAgencia() {
	}
	public MAgencia(Long id, String agNombre, String agTelefono, String agDireccion) {
		this.id = id;
		this.agNombre = agNombre;
		this.agTelefono = agTelefono;
		this.agDireccion = agDireccion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAgNombre() {
		return agNombre;
	}
	public void setAgNombre(String agNombre) {
		this.agNombre = agNombre;
	}
	public String getAgTelefono() {
		return agTelefono;
	}
	public void setAgTelefono(String agTelefono) {
		this.agTelefono = agTelefono;
	}
	public String getAgDireccion() {
		return agDireccion;
	}
	public void setAgDireccion(String agDireccion) {
		this.agDireccion = agDireccion;
	}
	@Override
	public String toString() {
		return "MAgencia [id=" + id + ", agNombre=" + agNombre + ", agTelefono=" + agTelefono + ", agDireccion="
				+ agDireccion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(agDireccion, agNombre, agTelefono, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MAgencia other = (MAgencia) obj;
		return Objects.equals(agDireccion, other.agDireccion) && Objects.equals(agNombre, other.agNombre)
				&& Objects.equals(agTelefono, other.agTelefono) && id == other.id;
	}
	
}
