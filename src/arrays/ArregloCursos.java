package arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.Alumno;
import models.Curso;

public class ArregloCursos {
	private ArrayList<Curso> cursos;
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	protected String dataSource = "data/cursos.json";
	
	public ArregloCursos() {
		this.cursos = new ArrayList<Curso>();
		cargarCursos();
	}
	
	public int tamaño() {
		return cursos.size();
	}
	
	public Curso obtener(int id) {
		return cursos.get(id);
	}
	
	public void adicionar(Curso curso) {
		cursos.add(curso);
		grabarCursos();
	}
	
	public void editar(int id, Curso curso) {
		cursos.set(id, curso);
		grabarCursos();
	}
	
	public void eliminar(int id) {
		cursos.remove(id);
		grabarCursos();
	}
	
	public Curso buscarPorCodigo(int codCurso) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodCurso() == codCurso) {
				return obtener(i);
			}
		}
		
		return obtener(-1);
	}
	
	public ArrayList<Alumno> obtenerAlumnos(int codCurso) {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ArregloMatriculas am = new ArregloMatriculas();
		ArregloAlumnos aa = new ArregloAlumnos();
		for (int i = 0; i < am.tamaño(); i++) {
			if (am.obtener(i).getCodCurso() == codCurso) {
				alumnos.add(aa.buscarPorCodigo(am.obtener(i).getCodAlumno()));
			}
		}
		
		return alumnos;
	}
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	private void cargarCursos() {
		try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
			cursos = gson.fromJson(br, new TypeToken<ArrayList<Curso>>(){}.getType());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void grabarCursos() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataSource))) {
			String json = gson.toJson(cursos);
			
			bw.write(json);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean existeCurso(int codCurso) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodCurso() == codCurso) {
				return true;
			}
		}
		return false;
	}
}
