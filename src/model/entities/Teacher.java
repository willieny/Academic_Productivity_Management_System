package model.entities;

public class Teacher extends Collaborator{

	public Teacher(String name, String email) {
		super(name, email);
	}

	@Override
	public String toString() {
		return "\nProfessor" + "\nnome: " + getName() + ", email: " + getEmail();
	}

}
