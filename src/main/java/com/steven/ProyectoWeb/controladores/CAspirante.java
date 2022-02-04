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

import com.steven.ProyectoWeb.modelos.MAspirante;
import com.steven.ProyectoWeb.servicios.SAspirante;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/aspirante")
public class CAspirante {
	@Autowired
	SAspirante serAspirante;
	
	@GetMapping
	public ArrayList<MAspirante> obtener(){
		return serAspirante.obtenerTodos();
	}
	
	@PostMapping
	public MAspirante crear(@RequestBody MAspirante aspirante) {
		return serAspirante.guardar(aspirante);
	}
	
	@GetMapping (path="{id}")
	public Optional<MAspirante> obtenerPorId(@PathVariable("id") Long id){
		return serAspirante.obtenerPorId(id);
	}
	
	@DeleteMapping(path="{id}")
	public String eliminar(@PathVariable("id") Long id) {
		boolean esEliminado = serAspirante.eliminar(id);
		if(esEliminado) return "Aspirante Eliminado";
		else return "Error Eliminando Aspirante";
	}
	
	@GetMapping (path="letra/{letra}")
	public ArrayList<MAspirante> obtenerPorLetra(@PathVariable("letra") String letra){
		return serAspirante.obtenerPorLetra(letra);
	}
	
	@GetMapping (path="generoprofesion/{genero}/{profesion}")
	public ArrayList<MAspirante> obtenerPorGeneroProfesion(@PathVariable("genero") char genero, @PathVariable("profesion") int idProfesion){
		return serAspirante.obtenerPorGeneroProfesion(genero, idProfesion);
	}
	
	@GetMapping (path="mayor")
	public MAspirante obtenerMayor() {
		return serAspirante.obtenerMayor();
	}
	
	@GetMapping (path="profesion/{profesion}")
	public ArrayList<MAspirante> obtenerPorGeneroProfesion(@PathVariable("profesion") int idProfesion){
		return serAspirante.obtenerPorProfesion(idProfesion);
	}
}
