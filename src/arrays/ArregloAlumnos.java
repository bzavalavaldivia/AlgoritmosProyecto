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
}
