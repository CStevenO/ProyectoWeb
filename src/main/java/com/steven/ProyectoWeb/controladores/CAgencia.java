package com.steven.ProyectoWeb.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.steven.ProyectoWeb.modelos.MAgencia;
import com.steven.ProyectoWeb.servicios.SAgencia;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/agencia")
public class CAgencia {
	@Autowired
	SAgencia serAgencia;
	
	@GetMapping
	public ArrayList<MAgencia> obtener(){
		return serAgencia.obtenerTodos();
	}
	
	@PostMapping
	public MAgencia crear(@RequestBody MAgencia agencia) {
		return serAgencia.guardar(agencia);
	}
	
	@GetMapping (path="{id}")
	public Optional<MAgencia> obtenerPorId(@PathVariable("id") Long id){
		return serAgencia.obtenerPorId(id);
	}
	
	@DeleteMapping(path="{id}")
	public String eliminar(@PathVariable("id") Long id) {
		boolean esEliminado = serAgencia.eliminar(id);
		if(esEliminado) return "Agencia Eliminada";
		else return "Error Eliminando Agencia";
	}
}
