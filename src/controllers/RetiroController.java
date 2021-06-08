package controllers;

import java.util.ArrayList;

import arrays.ArregloRetiros;
import models.Retiro;

public class RetiroController {
	private ArregloRetiros retiros;
	
	public ArrayList<Retiro> index() {
		return retiros.getRetiros();
	}
	
	public Retiro show(int id) {
		return retiros.obtener(id);
	}
	
	public String store(Retiro retiro) {
		try {
			retiros.adicionar(retiro);
			
			return "Retiro registrado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al registrar el retiro.";
		}
	}
	
	public String update(int id, Retiro retiro) {
		try {
			retiros.editar(id, retiro);
			
			return "Retiro actualizado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al actualizar el retiro.";
		}
	}
	
	public String destroy(int id) {
		try {
			retiros.eliminar(id);
			
			return "Retiro eliminado correctamente.";
		} catch (Exception e) {
			return "Hubo un error al eliminar el retiro.";
		}
	}
}
