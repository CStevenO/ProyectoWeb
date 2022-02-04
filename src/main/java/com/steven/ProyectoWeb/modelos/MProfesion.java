package com.steven.ProyectoWeb.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Profesion")
public class MProfesion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idProfesion;
	private String pNombre;
	
	public MProfesion() {
		super();
	}

	public MProfesion(int idProfesion, String pNombre) {
		super();
		this.idProfesion = idProfesion;
		this.pNombre = pNombre;
	}

	public int getIdProfesion() {
		return idProfesion;
	}

	public void setIdProfesion(int idProfesion) {
		this.idProfesion = idProfesion;
	}

	public String getpNombre() {
		return pNombre;
	}

	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}

	@Override
	public String toString() {
		return "MProfesion [idProfesion=" + idProfesion + ", pNombre=" + pNombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProfesion, pNombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MProfesion other = (MProfesion) obj;
		return idProfesion == other.idProfesion && Objects.equals(pNombre, other.pNombre);
	}
	
}
