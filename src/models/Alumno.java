package models;

public class Alumno {
	private int codAlumno; //correlativo (202010001)
	private String nombres;
	private String apellidos;
	private String dni;
	private int edad;
	private int celular;
	private int estado; //0 = registrado, 1 = matriculado, 2 = retirado
	
	public Alumno(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		super();
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	@Override
    public String toString() {
        return "Alumno [" + "codAlumno=" + codAlumno + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + ", celular=" + celular + ", estado=" + estado + "]";
    }
}
