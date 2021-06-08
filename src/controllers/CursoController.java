package controllers;

import java.util.ArrayList;

import arrays.ArregloCursos;
import models.Curso;

public class CursoController {
	private ArregloCursos cursos;
	
	public ArrayList<Curso> index() {
		return cursos.getCursos();
	}
	
	public Curso show(int id) {
		return cursos.obtener(id);
	}
	
	public String store(Curso curso) {
		try {
			cursos.adicionar(curso);
			
			return "Curso registrado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al registrar el curso.";
		}
	}
	
	public String update(int id, Curso curso) {
		try {
			cursos.editar(id, curso);
			
			return "Curso actualizado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al actualizar el curso.";
		}
	}
	
	public String destroy(int id) {
		try {
			cursos.eliminar(id);
			
			return "Curso eliminado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al eliminar el curso.";
		}
	}
}
