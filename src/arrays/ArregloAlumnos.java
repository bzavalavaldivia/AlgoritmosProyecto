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

public class ArregloAlumnos {
	private ArrayList<Alumno> alumnos;
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	protected String dataSource = "data/alumnos.json";
	
	public ArregloAlumnos() {
		this.alumnos = new ArrayList<Alumno>();
		cargarAlumnos();
	}
	
	public int tamaño() {
		return alumnos.size();
	}
	
	public Alumno obtener(int id) {
		return alumnos.get(id);
	}
	
	public void adicionar(Alumno alumno) {
		alumnos.add(alumno);
		grabarAlumnos();
	}
	
	public void editar(int id, Alumno alumno) {
		alumnos.set(id, alumno);
		grabarAlumnos();
	}
	
	public void eliminar(int id) {
		alumnos.remove(id);
		grabarAlumnos();
	}
	
	public Alumno buscarPorCodigo(int codAlumno) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodAlumno() == codAlumno) {
				return obtener(i);
			}
		}
		
		return obtener(-1);
	}
	
	public ArrayList<Curso> obtenerCursos(int codAlumno) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ArregloMatriculas am = new ArregloMatriculas();
		ArregloCursos ac = new ArregloCursos();
		for (int i = 0; i < am.tamaño(); i++) {
			if (am.obtener(i).getCodAlumno() == codAlumno) {
				cursos.add(ac.buscarPorCodigo(am.obtener(i).getCodCurso()));
			}
		}
		
		return cursos;
	}
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	private void cargarAlumnos() {
		try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
			alumnos = gson.fromJson(br, new TypeToken<ArrayList<Alumno>>(){}.getType());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void grabarAlumnos() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataSource))) {
			String json = gson.toJson(alumnos);
			
			bw.write(json);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 202010001;
		else
			return obtener(tamaño()-1).getCodAlumno() + 1;
	}
	
	public boolean existeAlumno(int codAlumno) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodAlumno() == codAlumno) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeAlumnoDni(String dni) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeMatricula(int codAlumno) {
		ArregloMatriculas am = new ArregloMatriculas();
		for (int i = 0; i < am.tamaño(); i++) {
			if (am.obtener(i).getCodAlumno() == codAlumno) {
				return true;
			}
		}
		return false;
	}

	public int getIndex(int codAlumno) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodAlumno() == codAlumno) {
				return i;
			}
		}
		
		return -1;
	}
}
