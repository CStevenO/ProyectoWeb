package com.steven.ProyectoWeb.modelos;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_Oferta")
public class MOferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	private String ONombre;
	private String ODescripcion;
	private Date OFechaInicio;
	private Date OFechaFin;
	public MOferta() {
	}
	public MOferta(int id, String oNombre, String oDescripcion, Date oFechaInicio, Date oFechaFin) {
		this.id = id;
		ONombre = oNombre;
		ODescripcion = oDescripcion;
		OFechaInicio = oFechaInicio;
		OFechaFin = oFechaFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getONombre() {
		return ONombre;
	}
	public void setONombre(String oNombre) {
		ONombre = oNombre;
	}
	public String getODescripcion() {
		return ODescripcion;
	}
	public void setODescripcion(String oDescripcion) {
		ODescripcion = oDescripcion;
	}
	public Date getOFechaInicio() {
		return OFechaInicio;
	}
	public void setOFechaInicio(Date oFechaInicio) {
		OFechaInicio = oFechaInicio;
	}
	public Date getOFechaFin() {
		return OFechaFin;
	}
	public void setOFechaFin(Date oFechaFin) {
		OFechaFin = oFechaFin;
	}
	@Override
	public String toString() {
		return "MOferta [id=" + id + ", ONombre=" + ONombre + ", ODescripcion=" + ODescripcion + ", OFechaInicio="
				+ OFechaInicio + ", OFechaFin=" + OFechaFin + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ODescripcion, OFechaFin, OFechaInicio, ONombre, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MOferta other = (MOferta) obj;
		return Objects.equals(ODescripcion, other.ODescripcion) && Objects.equals(OFechaFin, other.OFechaFin)
				&& Objects.equals(OFechaInicio, other.OFechaInicio) && Objects.equals(ONombre, other.ONombre)
				&& Objects.equals(id, other.id);
	}
	
	
}
