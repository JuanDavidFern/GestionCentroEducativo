package models;

public class ValoracionMateria {
	
	private int id;
	private Profesor idProfesor;
	private Estudiante idEstudiante;
	private Materia idMateria;
	private float valoracion;


	public ValoracionMateria() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Profesor getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(Profesor idProfesor) {
		this.idProfesor = idProfesor;
	}


	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}


	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}


	public Materia getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(Materia idMateria) {
		this.idMateria = idMateria;
	}


	public float getValoracion() {
		return valoracion;
	}


	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}


	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", idProfesor=" + idProfesor + ", idEstudiante=" + idEstudiante
				+ ", idMateria=" + idMateria + ", valoracion=" + valoracion + "]";
	}


	public ValoracionMateria(int id, Profesor idProfesor, Estudiante idEstudiante, Materia idMateria,
			float valoracion) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.valoracion = valoracion;
	}
	
	

}