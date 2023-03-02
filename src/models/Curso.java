package models;

public class Curso {
	
	private int id;
	private String descri;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int id, String descri) {
		super();
		this.id = id;
		this.descri = descri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", descri=" + descri + "]";
	}
	

}
