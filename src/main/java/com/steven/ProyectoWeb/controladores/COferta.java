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

import com.steven.ProyectoWeb.modelos.MOferta;
import com.steven.ProyectoWeb.servicios.SOferta;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/oferta")
public class COferta {
	@Autowired
	SOferta serOferta;
	
	@GetMapping
	public ArrayList<MOferta> obtener(){
		return serOferta.obtenerTodos();
	}
	
	@PostMapping
	public MOferta crear(@RequestBody MOferta oferta) {
		return serOferta.guardar(oferta);
	}
	
	@GetMapping (path="{id}")
	public Optional<MOferta> obtenerPorId(@PathVariable("id") int id){
		return serOferta.obtenerPorId(id);
	}
	
	@DeleteMapping(path="{id}")
	public String eliminar(@PathVariable("id") int id) {
		boolean esEliminado = serOferta.eliminar(id);
		if(esEliminado) return "Oferta Eliminada";
		else return "Error Eliminando Oferta";
	}
	
	@GetMapping(path="habilitados")
	public ArrayList<MOferta> obtenerHabilitados(){
		return serOferta.obtenerHabilitados();
	}
}
