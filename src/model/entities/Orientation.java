package model.entities;

public class Orientation extends AcademicProduction{

	private Teacher teacher;

	public Orientation(String title, Teacher teacher) {
		super(title);
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		if(getAuthors().size() > 0) {
			return "\nTítulo: " + getTitle() + "\nAutores: " + getAuthors();
		}
		else {
			return "\nTítulo: " + getTitle() + "Sem autores.";
		}
	}
	
}
