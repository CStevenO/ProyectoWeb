package com.steven.ProyectoWeb.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.ProyectoWeb.modelos.MOferta;
import com.steven.ProyectoWeb.repositorios.ROferta;

@Service
public class SOferta {
	@Autowired
	ROferta repOferta;
	
	public MOferta guardar(MOferta oferta) {
		oferta.setOFechaInicio(new Date(oferta.getOFechaInicio().getTime() + (1000 * 60 * 60 * 24)));
		oferta.setOFechaFin(new Date(oferta.getOFechaFin().getTime() + (1000 * 60 * 60 * 24)));
		return repOferta.save(oferta);
	}
	
	public Optional<MOferta> obtenerPorId(int id){
		return repOferta.findById(id);
	}
	
	public ArrayList<MOferta> obtenerTodos(){
		return (ArrayList<MOferta>) repOferta.findAll();
	}
	
	public boolean eliminar(int id) {
		try {
			repOferta.deleteById(id);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<MOferta> obtenerHabilitados(){
		return repOferta.findBetweenDates();
	}
}
