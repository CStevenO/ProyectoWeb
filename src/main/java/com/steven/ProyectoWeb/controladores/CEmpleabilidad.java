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

import com.steven.ProyectoWeb.modelos.MEmpleabilidad;
import com.steven.ProyectoWeb.servicios.SEmpleabilidad;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/empleabilidad")
public class CEmpleabilidad {
	@Autowired
	SEmpleabilidad serEmpleabilidad;
	
	@GetMapping
	public ArrayList<MEmpleabilidad> obtener(){
		return serEmpleabilidad.obtenerTodos();
	}
	
	@PostMapping
	public MEmpleabilidad crear(@RequestBody MEmpleabilidad empleabilidad) {
		return serEmpleabilidad.guardar(empleabilidad);
	}
	
	@GetMapping (path="{id}")
	public Optional<MEmpleabilidad> obtenerPorId(@PathVariable("id") int id){
		return serEmpleabilidad.obtenerPorId(id);
	}
	
	@DeleteMapping(path="{id}")
	public String eliminar(@PathVariable("id") int id) {
		boolean esEliminado = serEmpleabilidad.eliminar(id);
		if(esEliminado) return "Empleabilidad Eliminada";
		else return "Error Eliminando Empleabilidad";
	}
}
