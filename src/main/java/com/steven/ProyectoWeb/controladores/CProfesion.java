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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.steven.ProyectoWeb.modelos.MProfesion;
import com.steven.ProyectoWeb.servicios.SProfesion;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/profesion")
public class CProfesion {
	@Autowired
	SProfesion serProfesion;
	
	@GetMapping
	public ArrayList<MProfesion> obtener(){
		return serProfesion.obtenerTodos();
	}
	
	@PostMapping
	public MProfesion crear(@RequestBody MProfesion profesion) {
		return serProfesion.guardar(profesion);
	}
	
	@GetMapping (path="{id}")
	public Optional<MProfesion> obtenerPorId(@PathVariable("id") int id){
		return serProfesion.obtenerPorId(id);
	}
	
	@DeleteMapping(path="{id}")
	public String eliminar(@PathVariable("id") int id) {
		boolean esEliminado = serProfesion.eliminar(id);
		if(esEliminado) return "Profesion Eliminada";
		else return "Error Eliminando Profesion";
	}
}
