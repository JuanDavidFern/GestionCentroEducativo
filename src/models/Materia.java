package models;

public class Materia {
	
	private int id;
	private String nombre;
	private String acronimo;
	private int curso_id;
	private String text;

	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(int id, String nombre, String acronimo, int curso_id, String text) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.curso_id = curso_id;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", acronimo=" + acronimo + ", curso_id=" + curso_id
				+ ", text=" + text + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	
	

}
