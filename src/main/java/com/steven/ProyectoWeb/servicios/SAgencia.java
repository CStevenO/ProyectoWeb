package com.steven.ProyectoWeb.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.ProyectoWeb.modelos.MAgencia;
import com.steven.ProyectoWeb.repositorios.RAgencia;

@Service
public class SAgencia {
	@Autowired
	RAgencia repAgencia;
	
	public MAgencia guardar(MAgencia agencia) {
		return repAgencia.save(agencia);
	}
	
	public Optional<MAgencia> obtenerPorId(Long id){
		return repAgencia.findById(id);
	}
	
	public ArrayList<MAgencia> obtenerTodos(){
		return (ArrayList<MAgencia>) repAgencia.findAll();
	}
	
	public boolean eliminar(Long id) {
		try {
			repAgencia.deleteById(id);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
