package com.steven.ProyectoWeb.modelos;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Empleabilidad")
public class MEmpleabilidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idAspirante", nullable = false)
	private MAspirante aspirante;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idOferta", nullable = false)
	private MOferta oferta;
	private Date eFecha;
	public MEmpleabilidad() {
	}
	public MEmpleabilidad(int id, MAspirante aspirante, MOferta oferta, Date eFecha) {
		this.id = id;
		this.aspirante = aspirante;
		this.oferta = oferta;
		this.eFecha = eFecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MAspirante getAspirante() {
		return aspirante;
	}
	public void setAspirante(MAspirante aspirante) {
		this.aspirante = aspirante;
	}
	public MOferta getOferta() {
		return oferta;
	}
	public void setOferta(MOferta oferta) {
		this.oferta = oferta;
	}
	public Date geteFecha() {
		return eFecha;
	}
	public void seteFecha(Date eFecha) {
		this.eFecha = eFecha;
	}
	@Override
	public String toString() {
		return "MEmpleabilidad [id=" + id + ", aspirante=" + aspirante + ", oferta=" + oferta + ", eFecha=" + eFecha
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(aspirante, eFecha, id, oferta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MEmpleabilidad other = (MEmpleabilidad) obj;
		return Objects.equals(aspirante, other.aspirante) && Objects.equals(eFecha, other.eFecha) && id == other.id
				&& Objects.equals(oferta, other.oferta);
	}
	
}
