package com.steven.ProyectoWeb.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Aspirante")
public class MAspirante {
	@Id
	@Column(unique = true, nullable = false)
	private Long id;
	private String AsNombre;
	private int AsEdad;
	private char AsGenero;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idProfesion",nullable = false)
	private MProfesion profesion;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idAgencia",nullable = false)
	private MAgencia agencia;
	public MAspirante() {
	}
	public MAspirante(Long id, String asNombre, int asEdad, char asGenero, MProfesion profesion, MAgencia agencia) {
		this.id = id;
		AsNombre = asNombre;
		AsEdad = asEdad;
		AsGenero = asGenero;
		this.profesion = profesion;
		this.agencia = agencia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAsNombre() {
		return AsNombre;
	}
	public void setAsNombre(String asNombre) {
		AsNombre = asNombre;
	}
	public int getAsEdad() {
		return AsEdad;
	}
	public void setAsEdad(int asEdad) {
		AsEdad = asEdad;
	}
	public char getAsGenero() {
		return AsGenero;
	}
	public void setAsGenero(char asGenero) {
		AsGenero = asGenero;
	}
	public MProfesion getProfesion() {
		return profesion;
	}
	public void setProfesion(MProfesion profesion) {
		this.profesion = profesion;
	}
	public MAgencia getAgencia() {
		return agencia;
	}
	public void setAgencia(MAgencia agencia) {
		this.agencia = agencia;
	}
	@Override
	public String toString() {
		return "MAspirante [id=" + id + ", AsNombre=" + AsNombre + ", AsEdad=" + AsEdad + ", AsGenero=" + AsGenero
				+ ", profesion=" + profesion + ", agencia=" + agencia + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(AsEdad, AsGenero, AsNombre, agencia, id, profesion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MAspirante other = (MAspirante) obj;
		return AsEdad == other.AsEdad && AsGenero == other.AsGenero && Objects.equals(AsNombre, other.AsNombre)
				&& Objects.equals(agencia, other.agencia) && id == other.id
				&& Objects.equals(profesion, other.profesion);
	}
	
}
