package model.entities;

import model.enums.TypeStudent;

public class Student extends Collaborator{

	private TypeStudent typeStudent;

	public Student(Integer id, String name, String email, TypeStudent typeStudent) {
		super(id, name, email);
		this.typeStudent = typeStudent;
	}

	public TypeStudent getTypeStudent() {
		return typeStudent;
	}

	public void setTypeStudent(TypeStudent typeStudent) {
		this.typeStudent = typeStudent;
	}
	
	@Override
	public String toString() {
		return "\nid: " + getId() + "\nNome: " + getName() + "\ne-mail: " + getEmail() + "\nCargo: " + typeStudent.getTypeStudent();
	}
}
