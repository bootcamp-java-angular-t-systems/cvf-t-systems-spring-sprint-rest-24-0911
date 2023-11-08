package com.example.demo.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;
import com.example.demo.enums.Trabajo;

@Component

public class DataLoader {
	@Autowired
    private IEmpleadoDAO employeeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadDataHospital(){

        var employees = List.of(
                new Empleado("Empleado 1", Trabajo.DIRECTIVO),
                new Empleado ("Empleado 2", Trabajo.JUNIOR),
                new Empleado("Empleado 3", Trabajo.JUNIOR),
                new Empleado ("Empleado 4", Trabajo.MID),
                new Empleado("Empleado 5", Trabajo.SENIOR));

        employeeRepository.saveAll(employees);
    }

}