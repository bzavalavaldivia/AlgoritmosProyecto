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

import models.Retiro;

public class ArregloRetiros {
	private ArrayList<Retiro> retiros;
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	protected String dataSource = "data/retiros.json";
	
	public ArregloRetiros() {
		this.retiros = new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	public int tama?o() {
		return retiros.size();
	}
	
	public Retiro obtener(int id) {
		return retiros.get(id);
	}
	
	public void adicionar(Retiro retiro) {
		retiros.add(retiro);
		grabarRetiros();
	}
	
	public void editar(int id, Retiro retiro) {
		retiros.set(id, retiro);
		grabarRetiros();
	}
	
	public void eliminar(int id) {
		retiros.remove(id);
		grabarRetiros();
	}
	
	public Retiro buscarPorCodigo(int numRetiro) {
		for (int i = 0; i < tama?o(); i++) {
			if (obtener(i).getNumRetiro() == numRetiro) {
				return obtener(i);
			}
		}
		
		return obtener(-1);
	}
	
	public ArrayList<Retiro> getRetiros() {
		return retiros;
	}

	public void setRetiros(ArrayList<Retiro> retiros) {
		this.retiros = retiros;
	}
	
	private void cargarRetiros() {
		try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
			retiros = gson.fromJson(br, new TypeToken<ArrayList<Retiro>>(){}.getType());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void grabarRetiros() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataSource))) {
			String json = gson.toJson(retiros);
			
			bw.write(json);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int codigoCorrelativo() {
		if (tama?o() == 0)
			return 200001;
		else
			return obtener(tama?o()-1).getNumRetiro() + 1;
	}
	
	public boolean existeRetiro(int numRetiro) {
		for (int i = 0; i < tama?o(); i++) {
			if (obtener(i).getNumRetiro() == numRetiro) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeRetiroMatricula(int numMatricula) {
		for (int i = 0; i < tama?o(); i++) {
			if (obtener(i).getNumMatricula() == numMatricula) {
				return true;
			}
		}
		return false;
	}
}
