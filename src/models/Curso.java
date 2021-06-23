package models;

public class Curso {
	private int codCurso;
	private String asignatura;
	private int ciclo; //0 = primero, 1 = segundo... 5 = sexto
	private int creditos;
	private int horas;
	
	public Curso(int codCurso, String asignatura, int ciclo, int creditos, int horas) {
		super();
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public String getTipoCiclo(int estado) {
		String tipo = null;
		
		if (estado == 0) {
			tipo = "PRIMERO";
		} else if (estado == 1) {
			tipo = "SEGUNDO";
		} else if (estado == 2) {
			tipo = "TERCERO";
		} else if (estado == 3) {
			tipo = "CUARTO";
		} else if (estado == 4) {
			tipo = "QUINTO";
		} else if (estado == 5) {
			tipo = "SEXTO";
		}
		
		return tipo;
	}
	
	@Override
    public String toString() {
        return "cURSO [" + "codCurso=" + codCurso + ", asignatura=" + asignatura + ", ciclo=" + ciclo + ", creditos=" + creditos + ", horas=" + horas + "]";
    }
}
