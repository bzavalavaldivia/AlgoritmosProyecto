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

import models.Matricula;

public class ArregloMatriculas {
	private ArrayList<Matricula> matriculas;
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	protected String dataSource = "data/matriculas.json";
	
	public ArregloMatriculas() {
		this.matriculas = new ArrayList<Matricula>();
		cargarMatriculas();
	}
	
	public int tamaño() {
		return matriculas.size();
	}
	
	public Matricula obtener(int id) {
		return matriculas.get(id);
	}
	
	public void adicionar(Matricula matricula) {
		matriculas.add(matricula);
		grabarMatriculas();
	}
	
	public void editar(int id, Matricula matricula) {
		matriculas.set(id, matricula);
		grabarMatriculas();
	}
	
	public void eliminar(int id) {
		matriculas.remove(id);
		grabarMatriculas();
	}
	
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setCursos(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	private void cargarMatriculas() {
		try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
			matriculas = gson.fromJson(br, new TypeToken<ArrayList<Matricula>>(){}.getType());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void grabarMatriculas() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataSource))) {
			String json = gson.toJson(matriculas);
			
			bw.write(json);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
