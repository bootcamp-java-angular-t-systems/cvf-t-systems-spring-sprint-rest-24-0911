package com.example.demo.dto;


import com.example.demo.enums.Trabajo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private Trabajo trabajo;
	private double salario;
	

	public Empleado() {
		super();
	}
	
	
	public Empleado(String nombre, Trabajo trabajo) {
		super();
		this.nombre = nombre;
		this.trabajo = trabajo;
		this.salario = setSalario();
	}


	public double setSalario() {
		double salario = 0.0;
		
		switch (this.trabajo) {
			case DIRECTIVO:
				salario = 100000.0;
				break;
			case JUNIOR:
				salario = 18000.0;
				break;
			case MID:
				salario = 30000.0;
				break;
			case SENIOR:
				salario = 42000.0;
				break;
		}
		
		return salario;
	}

	
	
	public Trabajo getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}

	
	
		
}
