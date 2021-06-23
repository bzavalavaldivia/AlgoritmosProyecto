package controllers;

import java.util.ArrayList;

import arrays.ArregloAlumnos;
import models.Alumno;

public class AlumnoController {
	private ArregloAlumnos alumnos;
	
	public ArrayList<Alumno> index() {
		return alumnos.getAlumnos();
	}
	
	public Alumno show(int id) {
		return alumnos.obtener(id);
	}
	
	public String store(Alumno alumno) {
//		try {
		System.out.println(alumno.getNombres());
			alumnos.adicionar(alumno);
			
			return "Alumno registrado correctamente.";
//		} catch (Exception e) {
//			return "Hubo un error al registrar el alumno.";
//		}
	}
	
	public String update(int id, Alumno alumno) {
		try {
			alumnos.editar(id, alumno);
			
			return "Alumno actualizado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al actualizar el alumno.";
		}
	}
	
	public String destroy(int id) {
		try {
			alumnos.eliminar(id);
			
			return "Alumno eliminado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al eliminar el alumno.";
		}
	}
}
