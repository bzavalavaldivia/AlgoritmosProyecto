package models;

public class Matricula {
	private int numMatricula; //correlativo (100001)
	private int codAlumno;
	private int codCurso;
	private String fecha; //format("dd/mm/yyyy")
	private String hora; //format("hh:mm:ss")
	
	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora) {
		super();
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public int getNumMatricula() {
		return numMatricula;
	}
	
	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}
	
	public int getCodAlumno() {
		return codAlumno;
	}
	
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	public int getCodCurso() {
		return codCurso;
	}
	
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
}
