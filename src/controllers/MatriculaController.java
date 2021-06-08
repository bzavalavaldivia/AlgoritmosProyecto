package controllers;

import java.util.ArrayList;

import arrays.ArregloMatriculas;
import models.Matricula;

public class MatriculaController {
	private ArregloMatriculas matriculas;
	
	public ArrayList<Matricula> index() {
		return matriculas.getMatriculas();
	}
	
	public Matricula show(int id) {
		return matriculas.obtener(id);
	}
	
	public String store(Matricula matricula) {
		try {
			matriculas.adicionar(matricula);
			
			return "Matricula registrada correctamente.";
		} catch (Exception e) {
			return "Hubo un error al registrar la matricula.";
		}
	}
	
	public String update(int id, Matricula matricula) {
		try {
			matriculas.editar(id, matricula);
			
			return "Matricula actualizada correctamente.";
		} catch (Exception e) {
			return "Hubo un error al actualizar la matricula.";
		}
	}
	
	public String destroy(int id) {
		try {
			matriculas.eliminar(id);
			
			return "Matricula eliminada correctamente.";
		} catch (Exception e) {
			return "Hubo un error al eliminar la matricula.";
		}
	}
}
