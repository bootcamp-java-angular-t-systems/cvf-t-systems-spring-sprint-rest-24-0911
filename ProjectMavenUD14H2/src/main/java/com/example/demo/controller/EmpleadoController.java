package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.services.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoService;
	
	@GetMapping("/all")
	public List<Empleado> listarEmpleados() {
		return empleadoService.listarEmpleados();
	}
	
	@GetMapping("/{id}")
	public Empleado empleadoXID(@PathVariable Integer id) {
		Empleado empleado = empleadoService.empleadoXID(id);
		return empleado;
	}
	
	@PostMapping("")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.guardarEmpleado(empleado);
	}
	
	
	@PutMapping("/{id}")
	public Empleado updateEmpleado(@PathVariable(name="id")Integer id,@RequestBody Empleado empleado) {
		
		Empleado empleadoSeleccionado= new Empleado();
		Empleado empleadoUpdated= new Empleado();
		
		empleadoSeleccionado= empleadoService.empleadoXID(id);
		
		empleadoSeleccionado.setNombre(empleado.getNombre());
		empleadoSeleccionado.setTrabajo(empleado.getTrabajo());
		empleadoSeleccionado.setSalario(empleado.getSalario());
		
		empleadoUpdated = empleadoService.actualizarEmpleado(empleadoSeleccionado);
		
		System.out.println("El cliente actualizado es: "+ empleadoUpdated);
		
		return empleadoUpdated;
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteEmpleado(@PathVariable(name="id")Integer id) {
		empleadoService.eliminarEmpleado(id);
		System.out.println("Empleado eliminado");
	}

}
