package model.entities;

import model.enums.TypeStudent;

public class Student extends Collaborator{

	private TypeStudent typeStudent;

	public Student(String name, String email, TypeStudent typeStudent) {
		super(name, email);
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
		return "\n" + typeStudent.getTypeStudent() + "\nnome: " + getName() + ", email: " + getEmail();
	}
}
