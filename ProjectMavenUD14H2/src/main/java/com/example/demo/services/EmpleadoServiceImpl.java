package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;

@Service
public class EmpleadoServiceImpl {

	@Autowired
	IEmpleadoDAO empleadoDAO;

	public List<Empleado> listarEmpleados() {
		return empleadoDAO.findAll();
	}

	public Empleado empleadoXID(int id) {
		return empleadoDAO.findById(id).get();
	}

	public Empleado guardarEmpleado(Empleado empleado) {
		return empleadoDAO.save(empleado);
	}

	public Empleado actualizarEmpleado(Empleado empleado) {
		return empleadoDAO.save(empleado);
	}

	public void eliminarEmpleado(int id) {
		empleadoDAO.deleteById(id);
	}
}
